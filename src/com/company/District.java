package com.company;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String localDistrict;
    private Incident[] burglaryIncidents;

    public String getLocalDistrict() {
        return localDistrict;
    }

    public void setLocalDistrict(String localDistrict) {
        this.localDistrict = localDistrict;
    }

    public Incident[] getBurglaryIncidents() {
        return burglaryIncidents;
    }

    public void setBurglaryIncidents(Incident[] burglaryIncidents) {
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

        return (totalVal / burglaryIncidents.length);

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


