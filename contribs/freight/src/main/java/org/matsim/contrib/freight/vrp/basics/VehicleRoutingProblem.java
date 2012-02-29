package org.matsim.contrib.freight.vrp.basics;

import java.util.Collection;
import java.util.Map;

import org.matsim.contrib.freight.vrp.constraints.Constraints;



public interface VehicleRoutingProblem{
	
	public Collection<Vehicle> getVehicles();
	
	public Map<String,Job> getJobs();
	
	public Constraints getGlobalConstraints();
	
	public Costs getCosts();
	
	public Locations getLocations();

}
