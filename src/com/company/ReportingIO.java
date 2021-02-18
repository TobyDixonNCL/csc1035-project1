package com.company;

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

            int page = Integer.parseInt(input.nextLine());

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

    }
}
