/* *********************************************************************** *
 * project: org.matsim.*
 * OnePercentBerlin10sTest.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2007 by the members listed in the COPYING,        *
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

package org.matsim.examples;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.config.Config;
import org.matsim.core.config.groups.QSimConfigGroup;
import org.matsim.core.config.groups.SimulationConfigGroup;
import org.matsim.core.events.EventsUtils;
import org.matsim.core.events.algorithms.EventWriterTXT;
import org.matsim.core.gbl.MatsimRandom;
import org.matsim.core.mobsim.framework.Mobsim;
import org.matsim.core.mobsim.qsim.ActivityEngine;
import org.matsim.core.mobsim.qsim.QSim;
import org.matsim.core.mobsim.qsim.TeleportationEngine;
import org.matsim.core.mobsim.qsim.agents.AgentFactory;
import org.matsim.core.mobsim.qsim.agents.DefaultAgentFactory;
import org.matsim.core.mobsim.qsim.agents.PopulationAgentSource;
import org.matsim.core.mobsim.qsim.qnetsimengine.QNetsimEngine;
import org.matsim.core.mobsim.queuesim.QueueSimulation;
import org.matsim.core.network.MatsimNetworkReader;
import org.matsim.core.population.MatsimPopulationReader;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.testcases.MatsimTestCase;
import org.matsim.utils.eventsfilecomparison.EventsFileComparator;

public class OnePercentBerlin10sTest extends MatsimTestCase {

	private static final Logger log = Logger.getLogger(OnePercentBerlin10sTest.class);

	public void testOnePercent10s() {
		Config config = loadConfig(null);
		String netFileName = "test/scenarios/berlin/network.xml";
		String popFileName = "test/scenarios/berlin/plans_hwh_1pct.xml.gz";
		String eventsFileName = getOutputDirectory() + "events.txt";
		String referenceEventsFileName = getInputDirectory() + "events.txt.gz";

		MatsimRandom.reset(7411L);

		config.addSimulationConfigGroup(new SimulationConfigGroup()) ;
		config.simulation().setTimeStepSize(10.0);
		config.simulation().setFlowCapFactor(0.01);
		config.simulation().setStorageCapFactor(0.04);
		config.simulation().setRemoveStuckVehicles(false);
		config.simulation().setStuckTime(10.0);
		config.planCalcScore().setLearningRate(1.0);

		Scenario scenario = ScenarioUtils.createScenario(config);
		
		new MatsimNetworkReader(scenario).readFile(netFileName);
		new MatsimPopulationReader(scenario).readFile(popFileName);

		EventsManager events = EventsUtils.createEventsManager();
		EventWriterTXT writer = new EventWriterTXT(eventsFileName);
		events.addHandler(writer);

		Mobsim sim = new QueueSimulation(scenario, events);
		log.info("START testOnePercent10s SIM");
		sim.run();
		log.info("STOP testOnePercent10s SIM");

		writer.closeFile();

		assertTrue("different event files", EventsFileComparator.compare(referenceEventsFileName, eventsFileName) == 
			EventsFileComparator.CODE_FILES_ARE_EQUAL);
		
	}

	public void estOnePercent10sQSim() {
		Config config = loadConfig(null);
		String netFileName = "test/scenarios/berlin/network.xml";
		String popFileName = "test/scenarios/berlin/plans_hwh_1pct.xml.gz";
		String eventsFileName = getOutputDirectory() + "events.txt.gz";
		String referenceEventsFileName = getInputDirectory() + "events.txt.gz";

		MatsimRandom.reset(7411L);

		config.addQSimConfigGroup(new QSimConfigGroup()) ;
		config.getQSimConfigGroup().setTimeStepSize(10.0);
		config.getQSimConfigGroup().setFlowCapFactor(0.01);
		config.getQSimConfigGroup().setStorageCapFactor(0.04);
		config.getQSimConfigGroup().setRemoveStuckVehicles(false);
		config.getQSimConfigGroup().setStuckTime(10.0);
		config.planCalcScore().setLearningRate(1.0);

		Scenario scenario = ScenarioUtils.createScenario(config);
		
		new MatsimNetworkReader(scenario).readFile(netFileName);
		new MatsimPopulationReader(scenario).readFile(popFileName);

		EventsManager events = EventsUtils.createEventsManager();
		EventWriterTXT writer = new EventWriterTXT(eventsFileName);
		events.addHandler(writer);

		QSim qSim = new QSim(scenario, events);
		ActivityEngine activityEngine = new ActivityEngine();
		qSim.addMobsimEngine(activityEngine);
		qSim.addActivityHandler(activityEngine);
		QNetsimEngine netsimEngine = new QNetsimEngine(qSim);
		qSim.addMobsimEngine(netsimEngine);
		qSim.addDepartureHandler(netsimEngine.getDepartureHandler());
		TeleportationEngine teleportationEngine = new TeleportationEngine();
		qSim.addMobsimEngine(teleportationEngine);
		qSim.addDepartureHandler(teleportationEngine) ;
		AgentFactory agentFactory = new DefaultAgentFactory(qSim);
        PopulationAgentSource agentSource = new PopulationAgentSource(scenario.getPopulation(), agentFactory, qSim);
        qSim.addAgentSource(agentSource);


		log.info("START testOnePercent10s SIM");
		qSim.run();
		log.info("STOP testOnePercent10s SIM");

		writer.closeFile();

		assertTrue("different event files", EventsFileComparator.compare(referenceEventsFileName, eventsFileName) == EventsFileComparator.CODE_FILES_ARE_EQUAL);
		
	}

}