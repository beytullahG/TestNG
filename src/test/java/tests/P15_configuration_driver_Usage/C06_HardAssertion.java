package tests.P15_configuration_driver_Usage;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.lang.module.Configuration;

public class C06_HardAssertion {

    @Test
    public void hardAssertionTest(){

        // Go to the Test Automation homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Test that the title contains "Test"
        String expectedTitleContent = "Test";
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleContent));

        // Test that the URL is https://www.testotomasyonu.com/
        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);

        // Test that the search box is in a usable state
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        Assert.assertTrue(testAutomationPage.searchBox.isEnabled());

        // Test that a specified search term finds a product
        testAutomationPage
                .searchBox
                .sendKeys(ConfigReader.getProperty("toSearchKeyword") + Keys.ENTER);

        int foundResultCount = testAutomationPage.foundProductElementsList.size();
        Assert.assertTrue(foundResultCount > 1);

        // Test that searching for 'Nutella' does not find any products
        testAutomationPage.searchBox.clear();
        testAutomationPage.searchBox.sendKeys("Nutella" + Keys.ENTER);
        foundResultCount = testAutomationPage.foundProductElementsList.size();
        Assert.assertTrue(foundResultCount == 0);

        // Close the page
        Driver.closeDriver();
    }
}
