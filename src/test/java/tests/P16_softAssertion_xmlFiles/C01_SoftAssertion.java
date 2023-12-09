package tests.P16_softAssertion_xmlFiles;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssertion {

    @Test
    public void softAssertionTest() {
        /*
                - Create a softAssert object
                - Perform all assertions using the softAssert object
                - Request a report with assertAll() after the assertions are completed
         */

        // Go to the Test Automation homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        SoftAssert softAssert = new SoftAssert();

        // Test that the title contains "Test"
        String expectedTitleContent = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains(expectedTitleContent), "Title does not contain Test");

        // Test that the URL is https://www.testotomasyonu.com/
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "URL is different than expected");

        // Test that the search box is in a usable state
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        softAssert.assertTrue(testAutomationPage.searchBox.isEnabled(), "Search box is not usable");

        // Test that a specified search term finds a product
        testAutomationPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchKeyword") + Keys.ENTER);
        int foundResultCount = testAutomationPage.foundProductElementsList.size();
        softAssert.assertTrue(foundResultCount > 0, "Product not found when the specified term is searched");

        // Test that searching for "Nutella" does not find a product
        testAutomationPage.searchBox.clear();
        testAutomationPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        foundResultCount = testAutomationPage.foundProductElementsList.size();
        softAssert.assertTrue(foundResultCount == 0, "Nutella is found");
        softAssert.assertAll();

        // Close the page
        Driver.closeDriver();
    }
}
