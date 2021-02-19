package com.company;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains test cases for all methods (other than getters and setters) used
 * within this project. Each test creates a set of information that the method uses, and
 * assures that the method returns the correct information back.
 *
 * @author Toby Dixon
 */

public class Testing {

    // District Tests

    @Test
    public void testHighestVal(){

        List<Incident> incidents = new ArrayList<>();
        Incident a = new Incident(100, "ABC DEF", "January", 2002);
        Incident b = new Incident(200, "GHI JKL", "February", 2015);

        incidents.add(a);
        incidents.add(b);

        District dist = new District("Location" , incidents);

        assertEquals(b, dist.highestValue());
    }

    @Test
    public void testAvgIncVal(){
        List<Incident> incidents = new ArrayList<>();
        Incident a = new Incident(100, "ABC DEF", "January", 2015);
        Incident b = new Incident(200, "GHI JKL", "February", 2015);
        Incident c = new Incident(500, "MNO PQR", "March", 2017);

        incidents.add(a);
        incidents.add(b);
        incidents.add(c);

        District dist = new District("Location" , incidents);

        assertEquals(150, dist.avgIncValue(2015));
        assertEquals(500, dist.avgIncValue(2017));
    }

    @Test
    public void testIncAboveValDistrict(){

        List<Incident> incidents = new ArrayList<>();
        Incident a = new Incident(100, "ABC DEF", "January", 2015);
        Incident b = new Incident(200, "GHI JKL", "February", 2015);
        Incident c = new Incident(500, "MNO PQR", "March", 2017);

        incidents.add(a);
        incidents.add(b);
        incidents.add(c);

        District dist = new District("Location" , incidents);

        assertEquals(incidents, dist.incAboveValue(0));
        assertEquals(1, dist.incAboveValue(300).size());
        assertEquals(2, dist.incAboveValue(100).size());

    }

    // Reporting Tests
    @Test
    public void testLargeAvgVal(){

        Reporting.districts = new ArrayList<>();

        List<Incident> inc1 = new ArrayList<>();
        List<Incident> inc2 = new ArrayList<>();
        List<Incident> inc3 = new ArrayList<>();

        inc1.add(new Incident(200, "ABC DEF", "January", 2012));
        inc1.add(new Incident(400, "GHI JKL", "April", 2012));
        inc1.add(new Incident(5000, "MNO PQR", "May", 2012));

        inc2.add(new Incident(100, "ABC DEF", "January", 2012));
        inc2.add(new Incident(100, "GHI JKL", "April", 2013));
        inc2.add(new Incident(20, "MNO PQR", "May", 2002));

        inc3.add(new Incident(50, "ABC DEF", "January", 2012));
        inc3.add(new Incident(590, "GHI JKL", "April", 2012));
        inc3.add(new Incident(560, "MNO PQR", "May", 2002));

        District dist1 = new District("Location1", inc1);
        District dist2 = new District("Location2", inc2);
        District dist3 = new District("Location3", inc3);

        Reporting.districts.add(dist1);
        Reporting.districts.add(dist2);
        Reporting.districts.add(dist3);

        assertEquals(dist1, Reporting.largestAverageValue(2012));
    }

    @Test
    public void testLargest(){

        Reporting.districts = new ArrayList<>();

        List<Incident> inc1 = new ArrayList<>();
        List<Incident> inc2 = new ArrayList<>();
        List<Incident> inc3 = new ArrayList<>();

        Incident largest = new Incident(5000, "MNO PQR", "May", 2012);

        inc1.add(new Incident(200, "ABC DEF", "January", 2012));
        inc1.add(new Incident(400, "GHI JKL", "April", 2012));
        inc1.add(largest);

        inc2.add(new Incident(100, "ABC DEF", "January", 2012));
        inc2.add(new Incident(100, "GHI JKL", "April", 2013));
        inc2.add(new Incident(20, "MNO PQR", "May", 2002));

        inc3.add(new Incident(50, "ABC DEF", "January", 2012));
        inc3.add(new Incident(590, "GHI JKL", "April", 2012));
        inc3.add(new Incident(560, "MNO PQR", "May", 2002));

        District dist1 = new District("Location1", inc1);
        District dist2 = new District("Location2", inc2);
        District dist3 = new District("Location3", inc3);

        Reporting.districts.add(dist1);
        Reporting.districts.add(dist2);
        Reporting.districts.add(dist3);

        System.out.println(largest == Reporting.largestEver());


    }

    @Test
    public void testIncAboveValReport(){

        Reporting.districts = new ArrayList<>();

        List<Incident> inc1 = new ArrayList<>();
        List<Incident> inc2 = new ArrayList<>();

        Incident a = new Incident(100, "ABC DEF", "January", 2015);
        Incident b = new Incident(200, "GHI JKL", "February", 2015);
        Incident c = new Incident(500, "MNO PQR", "March", 2017);

        inc1.add(a);
        inc2.add(b);
        inc2.add(c);

        District dist1 = new District("Location" , inc1);
        District dist2 = new District("Location2" , inc2);

        Reporting.districts.add(dist1);
        Reporting.districts.add(dist2);

        assertEquals(2, Reporting.incAboveValue(100).size());
        assertEquals(1, Reporting.incAboveValue(300).size());
        assertEquals(3, Reporting.incAboveValue(0).size());

    }

    // ReportingIO Tests
    @Test
    public void testEnterDist(){

    }

    @Test
    public void testEnterInc(){

    }


}
