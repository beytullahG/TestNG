package tests.P14_TestNG;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.Driver;

public class C05_PageClassUsage {

    @Test
    public void searchTest() {
        // Navigate to the Test Automation homepage
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Perform a search for "phone"
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.searchBox.sendKeys("phone" + Keys.ENTER);

        // Verify that the number of found results is more than 1
        Assert.assertTrue(testAutomationPage.foundProductElementsList.size() > 1);

        // Print the search result count
        System.out.println(testAutomationPage.resultTextElement.getText());

        // Close the page
        Driver.closeDriver();
    }
}
