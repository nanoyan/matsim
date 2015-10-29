/* *********************************************************************** *
 * project: org.matsim.*
 * SignalSystemBasicsTest
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2009 by the members listed in the COPYING,        *
 *                   LICENSE and WARRANTY file.                            *
 * email           : info at matsim dot org                                *
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *   See also COPYING, LICENSE and WARRANTY file                           *
 *                                                                         *
 * *********************************************************************** */
package org.matsim.signalsystems;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.api.experimental.events.LinkEnterEvent;
import org.matsim.core.api.experimental.events.SignalGroupStateChangedEvent;
import org.matsim.core.api.experimental.events.handler.LinkEnterEventHandler;
import org.matsim.core.basic.v01.IdImpl;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.config.groups.QSimConfigGroup;
import org.matsim.core.config.groups.SignalSystemsConfigGroup;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.handler.SignalGroupStateChangedEventHandler;
import org.matsim.core.mobsim.qsim.QSim;
import org.matsim.core.mobsim.qsim.QSimFactory;
import org.matsim.core.scenario.ScenarioImpl;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.lanes.run.LaneDefinitonsV11ToV20Converter;
import org.matsim.signalsystems.builder.FromDataBuilder;
import org.matsim.signalsystems.data.SignalsData;
import org.matsim.signalsystems.data.SignalsScenarioLoader;
import org.matsim.signalsystems.data.signalcontrol.v20.SignalGroupSettingsData;
import org.matsim.signalsystems.data.signalcontrol.v20.SignalPlanData;
import org.matsim.signalsystems.data.signalcontrol.v20.SignalSystemControllerData;
import org.matsim.signalsystems.mobsim.QSimSignalEngine;
import org.matsim.signalsystems.mobsim.SignalEngine;
import org.matsim.signalsystems.model.SignalSystemsManager;
import org.matsim.testcases.MatsimTestUtils;

/**
 * Simple test case for the QueueSim signal system implementation.
 * One agent drives one round in the signal system default simple test
 * network.
 *
 * @author dgrether
 */
public class SignalSystemsOneAgentTest implements
		LinkEnterEventHandler, SignalGroupStateChangedEventHandler {

	private static final Logger log = Logger.getLogger(SignalSystemsOneAgentTest.class);

	private Id id1 = new IdImpl(1);
	private Id id2 = new IdImpl(2);
	private Id id100 = new IdImpl(100);
	
	private double link2EnterTime = Double.NaN;

	@Rule
	public MatsimTestUtils testUtils = new MatsimTestUtils();
	
	private Scenario createAndLoadTestScenario(){
		String plansFile = testUtils.getClassInputDirectory() + "plans1Agent.xml";
		Config conf = ConfigUtils.createConfig();
		conf.controler().setMobsim("qsim");
		conf.network().setInputFile(testUtils.getClassInputDirectory() + "network.xml.gz");
		String laneDefinitions = testUtils.getClassInputDirectory() + "testLaneDefinitions_v1.1.xml";
		String lanes20 = testUtils.getOutputDirectory() + "testLaneDefinitions_v2.0.xml";
		new LaneDefinitonsV11ToV20Converter().convert(laneDefinitions,lanes20, conf.network().getInputFile());
		conf.network().setLaneDefinitionsFile(lanes20);
		conf.plans().setInputFile(plansFile);
		conf.scenario().setUseLanes(true);
		conf.scenario().setUseSignalSystems(false);
		//as signals are configured below we don't need signals on
		conf.addQSimConfigGroup(new QSimConfigGroup());
		conf.getQSimConfigGroup().setStuckTime(1000);
		ScenarioImpl scenario = (ScenarioImpl) ScenarioUtils.loadScenario(conf);
		return scenario;
	}
	
	private void setSignalSystemConfigValues(SignalSystemsConfigGroup signalsConfig){
		String signalSystemsFile = testUtils.getClassInputDirectory() + "testSignalSystems_v2.0.xml";
		String signalGroupsFile = testUtils.getClassInputDirectory() + "testSignalGroups_v2.0.xml";
		String signalControlFile = testUtils.getClassInputDirectory() + "testSignalControl_v2.0.xml";
		String amberTimesFile = testUtils.getClassInputDirectory() + "testAmberTimes_v1.0.xml";
		signalsConfig.setSignalSystemFile(signalSystemsFile);
		signalsConfig.setSignalGroupsFile(signalGroupsFile);
		signalsConfig.setSignalControlFile(signalControlFile);
		signalsConfig.setAmberTimesFile(amberTimesFile);
	}

	/**
	 * Tests the setup with a traffic light that shows all the time green
	 */
	@Test
	public void testTrafficLightIntersection2arms1AgentV20() {
		//configure and load standard scenario
		Scenario scenario = this.createAndLoadTestScenario();
		SignalSystemsConfigGroup signalsConfig = scenario.getConfig().signalSystems();
		this.setSignalSystemConfigValues(signalsConfig);
		
		SignalsScenarioLoader signalsLoader = new SignalsScenarioLoader(signalsConfig);
		scenario.addScenarioElement(signalsLoader.loadSignalsData());
		
		EventsManager events = EventsUtils.createEventsManager();
		events.addHandler(this);
		this.link2EnterTime = 38.0;
		
		FromDataBuilder builder = new FromDataBuilder(scenario, events);
		SignalSystemsManager manager = builder.createAndInitializeSignalSystemsManager();
		SignalEngine engine = new QSimSignalEngine(manager);
		
		QSim qsim = (QSim) new QSimFactory().createMobsim(scenario, events);
		qsim.addQueueSimulationListeners(engine);
		qsim.run();
	}
	

	/**
	 * Tests the setup with a traffic light that shows all the time green
	 */
	@Test
	public void testSignalSystems1AgentGreenAtSec100() {
		//configure and load standard scenario
		Scenario scenario = this.createAndLoadTestScenario();
		SignalSystemsConfigGroup signalsConfig = scenario.getConfig().signalSystems();
		this.setSignalSystemConfigValues(signalsConfig);
		
		SignalsScenarioLoader signalsLoader = new SignalsScenarioLoader(signalsConfig);
		SignalsData signalsData = signalsLoader.loadSignalsData();
		scenario.addScenarioElement(signalsData);
		
		SignalSystemControllerData controllerData = signalsData.getSignalControlData().getSignalSystemControllerDataBySystemId().get(id2);
		SignalPlanData planData = controllerData.getSignalPlanData().get(id2);
		planData.setStartTime(0.0);
		planData.setEndTime(0.0);
		planData.setCycleTime(5 * 3600);
		SignalGroupSettingsData groupData = planData.getSignalGroupSettingsDataByGroupId().get(id100);
		groupData.setDropping(0);
		groupData.setOnset(100);
		
		EventsManager events = EventsUtils.createEventsManager();
		events.addHandler(this);
		this.link2EnterTime = 100.0;
		
		FromDataBuilder builder = new FromDataBuilder(scenario, events);
		SignalSystemsManager manager = builder.createAndInitializeSignalSystemsManager();
		SignalEngine engine = new QSimSignalEngine(manager);
		
		QSim qsim = (QSim) new QSimFactory().createMobsim(scenario, events);
		qsim.addQueueSimulationListeners(engine);
		qsim.run();
	}
	
	/**
	 * Tests the setup with a traffic light that shows all the time green
	 */
	@Test
	public void testIntergreensAbortOneAgentDriving() {
		//configure and load standard scenario
		Scenario scenario = this.createAndLoadTestScenario();
		SignalSystemsConfigGroup signalsConfig = scenario.getConfig().signalSystems();
		this.setSignalSystemConfigValues(signalsConfig);
		signalsConfig.setIntergreenTimesFile(testUtils.getClassInputDirectory() + "testIntergreenTimes_v1.0.xml");
		signalsConfig.setUseIntergreenTimes(true);
		signalsConfig.setActionOnIntergreenViolation(SignalSystemsConfigGroup.EXCEPTION_ON_INTERGREEN_VIOLATION);
		
		SignalsScenarioLoader signalsLoader = new SignalsScenarioLoader(signalsConfig);
		SignalsData signalsData = signalsLoader.loadSignalsData();
		scenario.addScenarioElement(signalsData);
		
		SignalSystemControllerData controllerData = signalsData.getSignalControlData().getSignalSystemControllerDataBySystemId().get(id2);
		SignalPlanData planData = controllerData.getSignalPlanData().get(id2);
		planData.setStartTime(0.0);
		planData.setEndTime(0.0);
		planData.setCycleTime(60);
		SignalGroupSettingsData groupData = planData.getSignalGroupSettingsDataByGroupId().get(id100);
		groupData.setDropping(0);
		groupData.setOnset(30);
		
		EventsManager events = EventsUtils.createEventsManager();

		FromDataBuilder builder = new FromDataBuilder(scenario, events);
		SignalSystemsManager manager = builder.createAndInitializeSignalSystemsManager();
		SignalEngine engine = new QSimSignalEngine(manager);
		
		QSim qsim = (QSim) new QSimFactory().createMobsim(scenario, events);
		qsim.addQueueSimulationListeners(engine);
		Exception ex = null;
		try{
			qsim.run();
		} catch (Exception e){
			log.info(e.getMessage());
			ex = e;
		}
		Assert.assertNotNull(ex);
	}

	
	
	@Override
	public void handleEvent(LinkEnterEvent e) {
		log.info("Link id: " + e.getLinkId().toString() + " enter time: " + e.getTime());
		if (e.getLinkId().equals(id1)){
			Assert.assertEquals(1.0, e.getTime(), MatsimTestUtils.EPSILON);
		}
		else if (e.getLinkId().equals(id2)){
			Assert.assertEquals(this.link2EnterTime, e.getTime(), MatsimTestUtils.EPSILON);
		}
	}

	@Override
	public void reset(int iteration) {
	}

	@Override
	public void handleEvent(SignalGroupStateChangedEvent event) {
		log.info("State changed : "  + event.getTime() + " " + event.getSignalSystemId() + " " + event.getSignalGroupId() + " " + event.getNewState());
	}

}