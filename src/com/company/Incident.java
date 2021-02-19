package com.company;

public class Incident {
    private float value;
    private String postcode;
    private String month;
    private int year;

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

    public void printInfo(){
        System.out.println("Value " + this.value);
        System.out.println("Month " + this.month);
        System.out.println("Postcode " + this.postcode);
        System.out.println("Year " + this.year);
    }

}
