package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * This class stores all the information regarding the report as a whole and it's relevant methods.
 *
 * @author Toby Dixon
 */

public class Reporting {

    public static List<District> districts = new ArrayList<>();


    /**
     * This returns the district with the highest average value of incidents in a given year
     * @param year The year in question
     * @return The District object with the highest average value
     */
    public static District largestAverageValue(int year){

        District currentDist = new District("NULL", new ArrayList<>());

        for (District district: districts){

            if (district.avgIncValue(year) > currentDist.avgIncValue(year)) {
                currentDist = district;
            }
        }

        return currentDist;

    }

    /**
     * This returns the highest valued incident ever recorded in the report
     * @return The incident with the largest value
     */
    public static Incident largestEver(){

        Incident currentInc = new Incident(0, "NULL", "NULL", 0);

        for (District district: districts){
            if (district.highestValue().getValue() > currentInc.getValue()){
                currentInc = district.highestValue();
            }
        }

        return currentInc;

    }

    /**
     * This returns a list of Incidents that are valued higher than a given cost.
     * @param value The cost to check above
     * @return A list of all Incidents valued above the cost
     */
    public static List<Incident> incAboveValue(float value){

        List<Incident> allInc = new ArrayList<>();

        for (District district: districts){
            allInc.addAll(district.incAboveValue(value));
        }

        return allInc;

    }


}
