package com.company;

import java.util.ArrayList;
import java.util.List;

public class Reporting {

    public District[] districts;

    public District[] getDistricts() {
        return districts;
    }

    public void setDistricts(District[] districts) {
        this.districts = districts;
    }

    public District largestAverageValue(){

        District currentDist = new District();

        for (District district: districts){

            if (district.avgIncValue() > currentDist.avgIncValue()){
                currentDist = district;
            }

        }

        return currentDist;

    }

    public Incident largestEver(){

        Incident currentInc = new Incident();

        for (District district: districts){
            if (district.highestValue().getValue() > currentInc.getValue()){
                currentInc = district.highestValue();
            }
        }

        return currentInc;

    }

    public List<Incident> incAboveValue(float value){

        List<Incident> allInc = new ArrayList<>();

        for (District district: districts){
            allInc.addAll(district.incAboveValue(value));
        }

        return allInc;

    }


}
