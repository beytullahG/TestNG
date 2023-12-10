package tests.P14_TestNG;

import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    @Test(dependsOnMethods = "testAutomationTest")
    public void amazonTest() {
        System.out.println("Amazon test PASSED");
    }

    @Test
    public void testAutomationTest() {
        //Assert.assertTrue(false);
        System.out.println("Test Automation test PASSED");
    }

    @Test(dependsOnMethods = "amazonTest")
    public void wiseQuarterTest() {
        System.out.println("Wise Quarter test PASSED");
    }
}
