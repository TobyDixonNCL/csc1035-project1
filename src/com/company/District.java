package com.company;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String localDistrict;
    private List<Incident> burglaryIncidents = new ArrayList<>();

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

    public Incident highestValue(){
        Incident currentInc = new Incident();

        for (Incident inc: burglaryIncidents){
            if (inc.getValue() > currentInc.getValue()){
                currentInc = inc;
            }
        }

        return currentInc;
    }

    public int avgIncValue(){
        int totalVal = 0;

        for (Incident inc: burglaryIncidents){
            totalVal += inc.getValue();
        }

        return (totalVal / burglaryIncidents.size());

    }

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


