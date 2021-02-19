package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class is controls how the user interfaces with the other classes and the users' inputs.
 * @author Toby Dixon
 */

public class ReportingIO {

    /**
     * This is the main method which is where the program is initiated
     * @param args
     */
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

    /**
     * This allows the user to report information about a new district
     */
    public static void enterDistrictData(){

        Scanner input = new Scanner(System.in);
        District newDist = new District(null, new ArrayList<>());
        System.out.println("Please enter the following:");
        System.out.println("Name of the district: ");
        newDist.setLocalDistrict(input.nextLine());
        Reporting.districts.add(newDist);

    }

    /**
     * This allows the user to report information about a new incident
     */
    public static void enterIncidentData(){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the following");
        float val;
        String postcode, month, localDist;
        int year;
        boolean distExists = false;

        while (true) {
            System.out.println("Value of the incident: ");
            try {
                val = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Unrecognised Input");
            }
        }

        while (true) {
            System.out.println("Postcode of the incident: ");
            try {
                postcode = input.nextLine();
                break;
            } catch (Exception e){
                System.out.println("Unrecognised Input");
            }
        }

        while (true) {
            System.out.println("Month the incident occurred in: ");
            try {
                month = input.nextLine();
                break;
            } catch (Exception e){
                System.out.println("Unrecognised Input");
            }
        }

        while (true) {
            System.out.println("Year the incident occurred in: ");
            try {
                year = Integer.parseInt(input.nextLine());
                break;
            } catch (Exception e){
                System.out.println("Unrecognised Input");
            }
        }


        System.out.println("District in which the incident occurred");
        localDist = input.nextLine();
        for (District dis: Reporting.districts){
            if (dis.getLocalDistrict().equals(localDist)){
                distExists = true;
                break;
            }
        }
        if (!distExists) {
            System.out.println("Unrecognised District");
            System.out.println("Returing to menu \n");
            try {
                Thread.sleep(600);
            } catch (Exception e){
                System.out.println("Sleep failed");
            }
        }

        Incident i = new Incident(val, postcode, month, year);

        if (distExists) {
            for (District dist : Reporting.districts) {
                try {
                    if (dist.getLocalDistrict().equals(localDist)) {
                        dist.getBurglaryIncidents().add(i);
                    }
                } catch (Exception NullPointerException) {
                    dist.setBurglaryIncidents(new ArrayList<>());
                }
            }
        }


    }

    /**
     * This allows the user to choose from 3 different reports that all return different information
     * about the Incidents and their Districts
     */

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
                    System.out.println("District: " + Reporting.largestAverageValue(year).getLocalDistrict());
                    running = false;
                }
                case 2 -> {
                    System.out.println("Highest reported: ");
                    Reporting.largestEver().printInfo();
                    running = false;
                }
                case 3 -> {
                    System.out.println("Please enter the value to be checked above: ");
                    int value = Integer.parseInt(input.nextLine());
                    List<Incident> incidents = Reporting.incAboveValue(value);
                    for (int i = 0; i < incidents.size(); i++) {
                        System.out.println((i + 1) + ": ");
                        incidents.get(i).printInfo();
                    }
                    running = false;
                }
                case 4 -> running = false;
            }
        }
    }
}
