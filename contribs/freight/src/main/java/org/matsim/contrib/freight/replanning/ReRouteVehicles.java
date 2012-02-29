package org.matsim.contrib.freight.replanning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Id;
import org.matsim.api.core.v01.network.Link;
import org.matsim.api.core.v01.network.Network;
import org.matsim.api.core.v01.population.Route;
import org.matsim.contrib.freight.carrier.Carrier;
import org.matsim.contrib.freight.carrier.ScheduledTour;
import org.matsim.contrib.freight.carrier.Tour.Leg;
import org.matsim.contrib.freight.carrier.Tour.TourActivity;
import org.matsim.contrib.freight.carrier.Tour.TourElement;
import org.matsim.core.population.routes.LinkNetworkRouteImpl;
import org.matsim.core.router.util.LeastCostPathCalculator;
import org.matsim.core.router.util.LeastCostPathCalculator.Path;

public class ReRouteVehicles implements CarrierPlanStrategyModule{

	private static Logger logger = Logger.getLogger(ReRouteVehicles.class);
	
	private LeastCostPathCalculator router;
	
	private Network network;
	
	private double mTravelled;
	
	public ReRouteVehicles(LeastCostPathCalculator router, Network network) {
		super();
		this.router = router;
		this.network = network;
	}

	@Override
	public void handleActor(Carrier carrier) {
		route(carrier.getSelectedPlan().getScheduledTours());
	}
	
	private void route(Collection<ScheduledTour> scheduledTours) {
		for(ScheduledTour tour : scheduledTours){
			double currTime = tour.getDeparture();
			Id prevLink = tour.getTour().getStartLinkId();
			Leg prevLeg = null;
			for(TourElement e : tour.getTour().getTourElements()){
				if(e instanceof Leg){
					prevLeg = (Leg) e;
					prevLeg.setDepartureTime(currTime);
				}
				if(e instanceof TourActivity){
					TourActivity act = (TourActivity) e;
					route(prevLeg, prevLink, act.getLocation());
					double expectedArrival = currTime + prevLeg.getExpectedTransportTime();
					act.setExpectedArrival(expectedArrival);
					double startAct = Math.max(expectedArrival, act.getTimeWindow().getStart()); 
					currTime = startAct + act.getDuration();
					act.setExpectedActStart(startAct);
					prevLink = act.getLocation();
				}
			}
			Id endLink = tour.getTour().getEndLinkId();
			route(prevLeg,prevLink,endLink);
		}
	}
	
	private void route(Leg prevLeg, Id fromLinkId, Id toLinkId) {
		if(fromLinkId.equals(toLinkId)){
			prevLeg.setExpectedTransportTime(0);
			LinkNetworkRouteImpl route = new LinkNetworkRouteImpl(fromLinkId,toLinkId);
			route.setDistance(0.0);
			route.setTravelTime(0.0);
			prevLeg.setRoute(route);
			return;
		}
		Path path = router.calcLeastCostPath(network.getLinks().get(fromLinkId).getToNode(), network.getLinks().get(toLinkId).getFromNode(), prevLeg.getDepartureTime());
//		logger.debug("fromLinkId="+fromLinkId+"; toLinkId="+toLinkId+"; time="+prevLeg.getDepartureTime()+"; tt=" + path.travelTime);
		prevLeg.setExpectedTransportTime(path.travelTime);
		Route route = createRoute(fromLinkId,path,toLinkId);
		prevLeg.setRoute(route);
	}
	
	private Route createRoute(Id fromLink, Path path, Id toLink) {
		LinkNetworkRouteImpl route = new LinkNetworkRouteImpl(fromLink, toLink);
		route.setLinkIds(fromLink, getLinkIds(path.links), toLink);
		return route;
	}
	
	private List<Id> getLinkIds(List<Link> links) {
		List<Id> linkIds = new ArrayList<Id>();
		for(Link l : links){
			linkIds.add(l.getId());
		}
		return linkIds;
	}


}
