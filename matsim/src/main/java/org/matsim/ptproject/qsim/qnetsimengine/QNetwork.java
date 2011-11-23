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

package org.matsim.ptproject.qsim.qnetsimengine;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.network.Node;
import org.matsim.vis.snapshotwriters.VisLink;
import org.matsim.vis.snapshotwriters.VisNetwork;

/**
 *
 * @author david
 * @author mrieser
 * @author dgrether
 */

class QNetwork implements VisNetwork, NetsimNetwork {

	private final Map<Id, AbstractQLink> links;

	private final Map<Id, QNode> nodes;

	private final Network network;

	private final NetsimNetworkFactory<QNode, AbstractQLink> queueNetworkFactory;

	QNetsimEngine simEngine;

	QNetwork(final Network network, final NetsimNetworkFactory<QNode, AbstractQLink> factory ) {
		this.network = network;
		this.queueNetworkFactory = factory;
		this.links = new LinkedHashMap<Id, AbstractQLink>((int)(network.getLinks().size()*1.1), 0.95f);
		this.nodes = new LinkedHashMap<Id, QNode>((int)(network.getLinks().size()*1.1), 0.95f);
	}


	public void initialize(QNetsimEngine simEngine) {
		this.simEngine = simEngine;
		for (Node n : network.getNodes().values()) {
			this.nodes.put(n.getId(), this.queueNetworkFactory.createNetsimNode(n, this));
		}
		for (Link l : network.getLinks().values()) {
			this.links.put(l.getId(), this.queueNetworkFactory.createNetsimLink(l, this, this.nodes.get(l.getToNode().getId())));
		}
		for (QNode n : this.nodes.values()) {
			n.init();
		}
	}

	@Override
	public Network getNetwork() {
		return this.network;
	}

	@Override
	public Map<Id, AbstractQLink> getNetsimLinks() {
		return Collections.unmodifiableMap(this.links);
	}

	@Override
	public Map<Id, ? extends VisLink> getVisLinks() {
		return Collections.unmodifiableMap(this.links);
	}

	@Override
	public Map<Id, QNode> getNetsimNodes() {
		return Collections.unmodifiableMap(this.nodes);
	}

	@Override
	public AbstractQLink getNetsimLink(final Id id) {
		return this.links.get(id);
	}

	@Override
	public NetsimNode getNetsimNode(final Id id) {
		return this.nodes.get(id);
	}



}
