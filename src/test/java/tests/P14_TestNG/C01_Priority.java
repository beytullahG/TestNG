package tests.P14_TestNG;

import org.testng.annotations.Test;

public class C01_Priority {

    @Test
    public void amazonTest() {
        System.out.println("Amazon test PASSED");
    }

    @Test(priority = 5)
    public void testAutomationTest() {
        System.out.println("Test Automation test PASSED");
    }

    @Test(priority = -5)
    public void wiseQuarterTest() {
        System.out.println("Wise Quarter test PASSED");
    }


}
