/* *********************************************************************** *
 * project: org.matsim.*
 * SocialVertex.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2010 by the members listed in the COPYING,        *
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
package org.matsim.contrib.socnetgen.sna.graph.social;

import org.matsim.contrib.socnetgen.sna.graph.spatial.SpatialVertex;

import java.util.List;

/**
 * @author illenberger
 *
 */
public interface SocialVertex extends SpatialVertex {

	public List<? extends SocialEdge> getEdges();
	
	public List<? extends SocialVertex> getNeighbours();
	
	public SocialPerson getPerson();
	
}
