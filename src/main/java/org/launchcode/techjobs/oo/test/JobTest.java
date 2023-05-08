package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.hamcrest.core.StringEndsWith.endsWith;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
@Test
    public void testSettingJobId() {
    Job firstJob = new Job();
    Job secondJob = new Job();
    assertNotEquals(firstJob.getId(), secondJob.getId());
}
@Test
    public void testJobConstructorSetsAllFields(){
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertTrue(testJob instanceof Job);
    assertTrue(testJob.getEmployer() instanceof Employer);
    assertEquals("ACME", testJob.getEmployer().toString());
    assertEquals("Product tester", testJob.getName());
    assertTrue(testJob.getLocation() instanceof Location);
    assertEquals("Desert", testJob.getLocation().toString());
    assertTrue(testJob.getPositionType() instanceof PositionType);
    assertEquals("Quality control", testJob.getPositionType().toString());
    assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    assertEquals("Persistence", testJob.getCoreCompetency().toString());
}
@Test
    public void testJobsForEquality() {
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(testJob.equals(testJob2));
}
@Test
public void testToStringStartsAndEndsWithNewLine() {
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String testJobString = testJob.toString();
    char firstChar = testJobString.charAt(0);
    char lastChar = testJobString.charAt(testJobString.length()-1);
    assertEquals('\n', firstChar);
    assertEquals('\n', lastChar);
}
@Test
    public void testToStringContainsCorrectLabelsAndData() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertEquals("\nID: "+ job1.getId() +
            "\nName: Product tester" +
            "\nEmployer: ACME" +
            "\nLocation: Desert" +
            "\nPosition Type: Quality control" +
            "\nCore Competency: Persistence" +
            "\n", job1.toString());
}
    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();
        assertEquals("\n ID: " + job.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available"+
                "\nCore Competency: Data not available" +
                "\n", jobString);
    }

}
