package org.launchcode.techjobs.oo.test;
import org.launchcode.techjobs.oo.Job;
import org.launchcode.techjobs.oo.Employer;
import org.launchcode.techjobs.oo.PositionType;
import org.launchcode.techjobs.oo.CoreCompetency;
import org.launchcode.techjobs.oo.Location;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;
import org.junit.Before;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job testJob;
    Job testJob2;
    Job testJob3;
    Job testJob3Clone;


    @Test
    public void testSettingJobId(){
        testJob = new Job();
        testJob2 = new Job();
        assertNotEquals(testJob.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals("Product tester", testJob3.getName());
        assertEquals("ACME", testJob3.getEmployer().getValue());
        assertEquals("Desert", testJob3.getLocation().getValue());
        assertEquals("Quality control", testJob3.getPositionType().getValue());
        assertEquals("Persistence", testJob3.getCoreCompetency().getValue());

        assertTrue(testJob3.getName() instanceof String);
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJob3Clone = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(testJob3Clone.equals(testJob3));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        testJob = new Job();
        String result = testJob.toString();
        int n = result.length();
        char charBegin = result.charAt(0);
        char charEnd = result.charAt(n-1);

        assertEquals('\n', charBegin);
        assertEquals('\n', charEnd);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String result = testJob3.toString();
        assertEquals(("\n" + "ID: " + testJob3.getId() + "\n" + "Name: Product tester\n" + "Employer: ACME\n" +
                          "Location: Desert\n" + "Position Type: Quality control\n" +
                          "Core Competency: Persistence\n"), result);
    }

    @Test
    public void testToStringHandlesEmptyField(){
        testJob = new Job();
        String result = testJob.toString();
        assertEquals(("\n" + "ID: " + testJob.getId() + "\n" + "Name: Data not available\n" + "Employer: Data not available\n" +
                "Location: Data not available\n" + "Position Type: Data not available\n" +
                "Core Competency: Data not available\n"), result);
    }
}
