package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a class that manages all the information relevant to a District object.
 * @author Toby Dixon
 */

public class District {


    private String localDistrict;
    private List<Incident> burglaryIncidents;

    /**
     * This is a constructor that links the parameter values to the field variables
     * @param localDistrict The name of the district
     * @param burglaryIncidents The list of incidents that happened within the district
     */
    public District(String localDistrict, List<Incident> burglaryIncidents){
        this.localDistrict = localDistrict;
        this.burglaryIncidents = burglaryIncidents;
    }

    public String getLocalDistrict() {
        return localDistrict;
    }

    public void setLocalDistrict(String localDistrict) {
        this.localDistrict = localDistrict;
    }

    public List<Incident> getBurglaryIncidents() {
        return burglaryIncidents;
    }

    public void setBurglaryIncidents(List<Incident> burglaryIncidents) {
        this.burglaryIncidents = burglaryIncidents;
    }

    /**
     * This returns the highest value incident within the district
     * @return Incident object with highest value
     */
    public Incident highestValue(){

        Incident i = new Incident(0, "NULL", "NULL", 0);

        for (Incident inc: burglaryIncidents){
            if (inc.getValue() > i.getValue()){
                i = inc;
            }
        }

        return i;
    }

    /**
     * This returns the average value of the incidents in a given year within this district
     * @param year The year in question
     * @return Integer average value of the incidents
     */
    public int avgIncValue(int year){
        int totalVal = 0;
        int totalInc = 0;

        for (Incident inc: burglaryIncidents){
            if (inc.getYear() == year) {
                totalVal += inc.getValue();
                totalInc++;
            }
        }


        if (totalVal != 0) {
            return (totalVal / totalInc);
        } else {
            return 0;
        }
    }


    /**
     * This returns a list of Incidents with a value above a given cost
     * @param cost The cost to check above
     * @return List of incidents with a value above cost
     */
    public List<Incident> incAboveValue(float cost){
        List<Incident> aboveVal = new ArrayList<>();

        for (Incident inc: burglaryIncidents){

            if (inc.getValue() > cost){
                aboveVal.add(inc);
            }

        }

        return aboveVal;

    }
}


