/* *********************************************************************** *
 * project: org.matsim.*
 * AdaptivePlanBasedSignalSystemControler
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
package org.matsim.signalsystems.control;

import org.matsim.signalsystems.config.SignalSystemConfiguration;
import org.matsim.signalsystems.systems.SignalGroupDefinition;


/**
 * @author dgrether
 *
 */
public abstract class AdaptivePlanBasedSignalSystemControler extends
		DefaultPlanBasedSignalSystemController implements AdaptiveSignalSystemControler {

	public AdaptivePlanBasedSignalSystemControler(
			SignalSystemConfiguration config) {
		super(config);
	}

	@Override
	public abstract boolean givenSignalGroupIsGreen(double time, SignalGroupDefinition signalGroup);
	
}
