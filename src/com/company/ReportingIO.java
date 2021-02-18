package com.company;

import java.util.List;
import java.util.Scanner;

public class ReportingIO {
    public static void main(String[] args){
        boolean running = true;
        Scanner input = new Scanner(System.in);

        while (running){

            System.out.println("""
                    --------------- Menu ---------------  
                    Select one of the following:
                    
                    1. Enter district data
                    2. Enter incident data
                    3. Provide reporting statistics
                    4. Exit
                    """);

            int page = 0;

            try {
                page = Integer.parseInt(input.nextLine());
            } catch (Exception NumberFormatException){
                System.out.println("Expected an integer input");
            }
            switch (page) {
                case 1 -> enterDistrictData();
                case 2 -> enterIncidentData();
                case 3 -> reportStats();
                case 4 -> running = false;
            }

        }

    }

    public static void enterDistrictData(){

        Scanner input = new Scanner(System.in);
        District newDist = new District();
        System.out.println("Please enter the following:");
        System.out.println("Name of the district: ");
        newDist.setLocalDistrict(input.nextLine());
        Reporting.districts.add(newDist);

    }

    public static void enterIncidentData(){

        Scanner input = new Scanner(System.in);
        Incident newInc = new Incident();
        System.out.println("Please enter the following");
        System.out.println("Value of the incident: ");
        newInc.setValue(Integer.parseInt(input.nextLine()));
        System.out.println("Postcode of the incident: ");
        newInc.setPostcode(input.nextLine());
        System.out.println("Month the incident occurred in: ");
        newInc.setMonth(input.nextLine());
        System.out.println("Year the incident occurred in: ");
        newInc.setYear(Integer.parseInt(input.nextLine()));
        System.out.println("District in which the incident occurred");
        String localDist = input.nextLine();

        for (District dist: Reporting.districts){
            if (dist.getLocalDistrict().equals(localDist)){
                dist.getBurglaryIncidents().add(newInc);
            }
        }


    }

    public static void reportStats() {

        boolean running = true;

        while (running) {
            Scanner input = new Scanner(System.in);
            System.out.println(""" 
                    --------------- Reports ---------------
                    Select one of the following:
                    1. Largest average value for a given 
                    year.
                    2. Highest reported incident.
                    3. All incidents valued over x amount.
                    4. Exit
                    """);

            int opt = 0;

            try {
                opt = Integer.parseInt(input.nextLine());
            } catch (Exception NumberFormatException) {
                System.out.println("Expected an integer input.");
            }

            switch (opt) {
                case 1 -> {
                    System.out.println("Please enter the year: ");
                    int year = Integer.parseInt(input.nextLine());
                    System.out.println("District: " + Reporting.largestAverageValue(year));
                }
                case 2 -> System.out.println("Highest reported: " + Reporting.largestEver());
                case 3 -> {
                    System.out.println("Please enter the value to be checked above: ");
                    int value = Integer.parseInt(input.nextLine());
                    List<Incident> incidents = Reporting.incAboveValue(value);
                    for (int i = 0; i < incidents.size(); i++) {
                        System.out.println(i + ". " + incidents.get(i).toString());
                    }
                }
                case 4 -> running = false;
            }
        }
    }
}
