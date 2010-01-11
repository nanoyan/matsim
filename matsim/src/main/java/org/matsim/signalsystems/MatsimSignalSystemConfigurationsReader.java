/* *********************************************************************** *
 * project: org.matsim.*
 * MatsimSignalSystemConfigurationReader
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

import java.io.IOException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.matsim.core.utils.io.MatsimFileTypeGuesser;
import org.matsim.core.utils.io.MatsimJaxbXmlParser;
import org.matsim.signalsystems.config.SignalSystemConfigurations;

import org.xml.sax.SAXException;


/**
 * Reader for (Light)SignalSystemConfigurations and the corresponding
 * file format (light)signalSystemConfigurations_v1.*.xsd. The correct parser is 
 * selected automatically if the xml file has a correct header.
 * @author dgrether
 *
 */
public class MatsimSignalSystemConfigurationsReader {

	private static final Logger log = Logger
			.getLogger(MatsimSignalSystemConfigurationsReader.class);

	public static final String SIGNALSYSTEMSCONFIG10 = "http://www.matsim.org/files/dtd/lightSignalSystemsConfig_v1.0.xsd";

	public static final String SIGNALSYSTEMSCONFIG11 = "http://www.matsim.org/files/dtd/signalSystemsConfig_v1.1.xsd";
	
	private SignalSystemConfigurations lightSignalSystemConfigs;


	public MatsimSignalSystemConfigurationsReader(SignalSystemConfigurations lssConfigs) {
		this.lightSignalSystemConfigs = lssConfigs;
	}

	@SuppressWarnings("deprecation")
	public void readFile(final String filename) {
		try {
			MatsimFileTypeGuesser fileTypeGuesser = new MatsimFileTypeGuesser(filename);
			String sid = fileTypeGuesser.getSystemId();
			MatsimJaxbXmlParser reader = null;
			if (sid != null) {
				if (sid.compareTo(SIGNALSYSTEMSCONFIG10) == 0) {
					reader = new LightSignalSystemConfigurationsReader10(this.lightSignalSystemConfigs, sid);
					log.info("Using LightSignalSystemConfigurationsReader11 ...");
					log.warn("This file format is deprecated, use signalSystemsConfig_v1.1.xsd instead");
				}
				else if (sid.compareTo(SIGNALSYSTEMSCONFIG11)== 0){
					reader = new SignalSystemConfigurationsReader11(this.lightSignalSystemConfigs, sid);
					log.info("Using SignalSystemConfigurationsReader11 .. ");
				} else {
					throw new IllegalArgumentException("Unknown file format.");
				}
			}	else {
				throw new IllegalArgumentException(MatsimFileTypeGuesser.SYSTEMIDNOTFOUNDMESSAGE);
			}
			reader.readFile(filename);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
