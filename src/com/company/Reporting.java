package com.company;

import java.util.ArrayList;
import java.util.List;

public class Reporting {

    public static List<District> districts = new ArrayList<>();

    public static District largestAverageValue(){

        District currentDist = new District();

        for (District district: districts){

            if (district.avgIncValue() > currentDist.avgIncValue()){
                currentDist = district;
            }

        }

        return currentDist;

    }

    public static Incident largestEver(){

        Incident currentInc = new Incident();

        for (District district: districts){
            if (district.highestValue().getValue() > currentInc.getValue()){
                currentInc = district.highestValue();
            }
        }

        return currentInc;

    }

    public static List<Incident> incAboveValue(float value){

        List<Incident> allInc = new ArrayList<>();

        for (District district: districts){
            allInc.addAll(district.incAboveValue(value));
        }

        return allInc;

    }


}
