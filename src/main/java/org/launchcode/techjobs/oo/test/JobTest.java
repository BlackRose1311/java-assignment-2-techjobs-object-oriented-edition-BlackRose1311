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
    assertEquals(new Employer("ACME"), testJob.getEmployer());
    assertEquals("Product tester", testJob.getName());
    assertEquals(new Location("Desert"), testJob.getLocation());
    assertEquals(new PositionType("Quality control"), testJob.getPositionType());
    assertEquals(new CoreCompetency("Persistence"), testJob.getCoreCompetency());
}
@Test
    public void testJobsForEquality() {
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job tJ2 = new Job("pt", new Employer("acme"), new Location("dsrt"), new PositionType("qc"), new CoreCompetency("pers"));
    assertNotEquals(testJob.getId(), tJ2.getId());
}
@Test
public void testToStringStartsAndEndsWithNewLine() {
    Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String testJobString = testJob.toString();
    assertTrue(testJobString.startsWith("\n"));
    assertTrue(testJobString.endsWith("\n"));
}
@Test
    public void testToStringContainsCorrectLabelsAndData() {
    Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    String job1String = job1.toString();
    assertTrue(job1String.contains("\n ID: "+ job1.getId()));
    assertTrue(job1String.contains("\n Name: Product tester"));
    assertTrue(job1String.contains("\n Employer: ACME"));
    assertTrue(job1String.contains("\n Location: Desert"));
    assertTrue(job1String.contains("\n Position Type: Quality control"));
    assertTrue(job1String.contains("\n Core Competency: Persistence"));
}
    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String jobString = job.toString();
        assertEquals("\n ID: " + job.getId() +
                "\n Name: Data not available" +
                "\n Employer: Data not available" +
                "\n Location: Data not available" +
                "\n Position Type: Data not available"+
                "\n Core Competency: Data not available" +
                "\n", jobString);
    }

}
