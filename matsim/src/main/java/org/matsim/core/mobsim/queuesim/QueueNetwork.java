/* *********************************************************************** *
 * project: org.matsim.*
 * QueueNetwork.java
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2007, 2009 by the members listed in the COPYING,  *
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

package org.matsim.core.mobsim.queuesim;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.Node;
import org.matsim.core.api.internal.MatsimNetworkObject;
import org.matsim.vis.snapshotwriters.AgentSnapshotInfo;
import org.matsim.vis.snapshotwriters.AgentSnapshotInfoFactory;
import org.matsim.vis.snapshotwriters.SnapshotLinkWidthCalculator;
import org.matsim.vis.snapshotwriters.VisLink;
import org.matsim.vis.snapshotwriters.VisNetwork;

/**
 * QueueNetwork is responsible for creating the QueueLinks and QueueNodes.
 *
 * @author david
 * @author mrieser
 * @author dgrether
 */
 class QueueNetwork implements VisNetwork, MatsimNetworkObject {
	 
	private QueueSimulation qSim = null ; // QueueNetwork can exist without qSim, so this is not enforced.

	private final Map<Id, QueueLink> queuelinks;

	private final Map<Id, QueueNode> queuenodes;

	private final Network networkLayer;
	
	private final SnapshotLinkWidthCalculator linkWidthCalculator = new SnapshotLinkWidthCalculator();
  private final AgentSnapshotInfoFactory snapshotInfoFactory = new AgentSnapshotInfoFactory(linkWidthCalculator);


	/*package*/ QueueNetwork(final Network networkLayer, QueueSimulation qSim2) {
		this.networkLayer = networkLayer;
		this.qSim = qSim2 ;

		this.queuelinks = new LinkedHashMap<Id, QueueLink>((int)(networkLayer.getLinks().size()*1.1), 0.95f);
		this.queuenodes = new LinkedHashMap<Id, QueueNode>((int)(networkLayer.getLinks().size()*1.1), 0.95f);
		if (! Double.isNaN(networkLayer.getEffectiveLaneWidth())){
			linkWidthCalculator.setLaneWidth(networkLayer.getEffectiveLaneWidth());
		}
		for (Node n : networkLayer.getNodes().values()) {
			this.queuenodes.put(n.getId(), new QueueNode(n, this));
		}
		for (Link l : networkLayer.getLinks().values()) {
			this.queuelinks.put(l.getId(), new QueueLink(l, this, this.queuenodes.get(l.getToNode().getId())));
		}
		for (QueueNode n : this.queuenodes.values()) {
			n.init();
		}
	}

	@Override
	public Network getNetwork() {
		return this.networkLayer;
	}

	/**
	 * Called whenever this object should dump a snapshot
	 * @return A collection with the current positions of all vehicles.
	 */
	/*package*/ Collection<AgentSnapshotInfo> getVehiclePositions() {
		Collection<AgentSnapshotInfo> positions = new ArrayList<AgentSnapshotInfo>();
		for (QueueLink link : this.queuelinks.values()) {
			link.getVisData().getAgentSnapshotInfo(positions);
		}
		return positions;
	}

	/*package*/ Map<Id, QueueLink> getQueueLinks() {
		return Collections.unmodifiableMap(this.queuelinks);
	}

//	@Deprecated // only used by christoph
//	public Map<Id, ? extends CapacityInformationLink> getCapacityInformationLinks() {
//		return Collections.unmodifiableMap( this.queuelinks ) ;
//	}

	/*package*/ Map<Id, QueueNode> getQueueNodes() {
		return Collections.unmodifiableMap(this.queuenodes);
	}

	@Override
	public Map<Id,? extends VisLink> getVisLinks() {
		return Collections.unmodifiableMap( this.queuelinks ) ;
	}

	/*package*/ QueueLink getQueueLink(final Id id) {
		return this.queuelinks.get(id);
	}

	/*package*/ QueueNode getQueueNode(final Id id) {
		return this.queuenodes.get(id);
	}

	public QueueSimulation getMobsim() {
		return qSim;
	}
	
	@Override
	public  AgentSnapshotInfoFactory getAgentSnapshotInfoFactory(){
		return this.snapshotInfoFactory;
	}

}