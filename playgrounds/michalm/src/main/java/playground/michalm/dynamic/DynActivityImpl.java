/* *********************************************************************** *
 * project: org.matsim.*
 *                                                                         *
 * *********************************************************************** *
 *                                                                         *
 * copyright       : (C) 2012 by the members listed in the COPYING,        *
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

package playground.michalm.dynamic;

public class DynActivityImpl
    implements DynActivity
{
    private String activityType;
    private double endTime;


    public DynActivityImpl(String activityType, double endTime)
    {
        this.activityType = activityType;
        this.endTime = endTime;
    }


    @Override
    public String getActivityType()
    {
        return activityType;
    }


    @Override
    public double getEndTime()
    {
        return endTime;
    }
}