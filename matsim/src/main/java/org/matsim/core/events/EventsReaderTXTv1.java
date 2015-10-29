/* *********************************************************************** *
 * project: org.matsim.*
 * EventsReaderTXTv1.java
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

package org.matsim.core.events;

import java.io.BufferedReader;
import java.io.IOException;

import org.matsim.api.core.v01.Id;
import org.matsim.core.api.experimental.events.ActivityEndEvent;
import org.matsim.core.api.experimental.events.ActivityStartEvent;
import org.matsim.core.api.experimental.events.Event;
import org.matsim.core.api.experimental.events.EventsFactory;
import org.matsim.core.api.experimental.events.EventsManager;
import org.matsim.core.api.internal.MatsimSomeReader;
import org.matsim.core.basic.v01.IdImpl;
import org.matsim.core.utils.io.IOUtils;
import org.matsim.core.utils.misc.StringUtils;

public class EventsReaderTXTv1 implements MatsimSomeReader {

	private BufferedReader infile = null;
	private final EventsManager events;
	private EventsFactory builder;

	public EventsReaderTXTv1(final EventsManager events) {
		super();
		this.events = events;
		this.builder = events.getFactory();
	}

	public void readFile(final String filename) {
		try {
			this.infile = IOUtils.getBufferedReader(filename);
			String line = this.infile.readLine();
			if ((line != null) && (line.charAt(0) >= '0') && (line.charAt(0) <= '9')) {
				/* The line starts with a number, so assume it's an event and parse it.
				 * Otherwise it is likely the header.  */
				parseLine(line);
			}
			// now all other lines should contain events
			while ( (line = this.infile.readLine()) != null) {
				parseLine(line);
			}
			this.infile.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	 public Event createEvent(final double time, final Id agentId, final Id linkId,
			final int flag, final String desc, final String acttype) {
		 Event data = null;

		switch (flag) {
			case 2:
				data = this.builder.createLinkLeaveEvent(time, agentId, linkId, null);
				break;
			case 5:
				data = this.builder.createLinkEnterEvent(time, agentId, linkId, null);
				break;
			case 3:
				data = this.builder.createAgentStuckEvent(time, agentId, linkId, null);
				break;
			case 4:
				data = this.builder.createAgentWait2LinkEvent(time, agentId, linkId, null);
				break;
			case 6:
				data = this.builder.createAgentDepartureEvent(time, agentId, linkId, null);
				break;
			case 0:
				data = this.builder.createAgentArrivalEvent(time, agentId, linkId, null);
				break;
			case 7:
				if ("".equals(acttype) && (desc != null)) {
					data = new ActivityStartEvent(time, agentId, linkId, null, desc.replace("actstart ", ""));
				} else {
					data = this.builder.createActivityStartEvent(time, agentId, linkId, null, acttype);
				}
				break;
			case 8:
				if ("".equals(acttype) && (desc != null)) {
					data = new ActivityEndEvent(time, agentId, linkId, null, desc.replace("actend ", ""));
				} else {
					data = this.builder.createActivityEndEvent(time, agentId, linkId, null, acttype);
				}
				break;
			case 9:
				data = this.builder.createAgentMoneyEvent(time, agentId, Double.parseDouble(desc.replace("agentMoney\t", "")));
				break;
			default:
				throw new RuntimeException("Type of events with flag = " + flag + " is not known!");
		}
		return data;

	}


	protected void parseLine(final String line) {
		String[] result = StringUtils.explode(line, '\t', 7);
		if (result.length == 7) {
			Event data = createEvent(Double.parseDouble(result[0]), new IdImpl(result[1]),	// time, vehId
					new IdImpl(result[3]),		// linkId
					Integer.parseInt(result[5]),		// nodeId
					result[6],		// description
					"");		// unused
			events.processEvent(data);
		}
	}

}