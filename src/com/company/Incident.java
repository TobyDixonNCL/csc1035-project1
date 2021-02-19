package com.company;

/**
 * This class stores all the information and methods relevant to an Incident object.
 * @author Toby Dixon
 */

public class Incident {
    private float value;
    private String postcode;
    private String month;
    private int year;


    /**
     * This is a constructor that links the parameter values to the field variables
     * @param value The cost of the incident
     * @param postcode The postcode where the incident happened
     * @param month The month in which the incident happened
     * @param year The year in which the incident happened
     */
    public Incident(float value, String postcode, String month, int year){
        this.value = value;
        this.postcode = postcode;
        this.month = month;
        this.year = year;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Prints out all the information stored within this class in a human readable format
     */
    public void printInfo(){
        System.out.println("Value " + this.value);
        System.out.println("Month " + this.month);
        System.out.println("Postcode " + this.postcode);
        System.out.println("Year " + this.year);
    }

}
