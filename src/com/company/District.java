package com.company;

import java.util.ArrayList;
import java.util.List;

public class District {
    private String localDistrict;
    private List<Incident> burglaryIncidents;

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

    public Incident highestValue(){

        Incident i = new Incident(0, "NULL", "NULL", 0);

        for (Incident inc: burglaryIncidents){
            if (inc.getValue() > i.getValue()){
                i = inc;
            }
        }

        return i;
    }

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


