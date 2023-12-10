package tests.P15_configuration_driver_Usage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_ConfigurationPropertiesUsage {

    @Test
    public void searchTest() {

        // Go to the testautomationu homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Search for the product specified in configuration.properties
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchKeyword") + Keys.ENTER);

        // Test whether the product is found in the search results
        int numberOfFoundProducts = testAutomationPage.foundProductElementsList.size();
        Assert.assertTrue(numberOfFoundProducts > 0);

        // Click on the first product
        testAutomationPage.foundProductElementsList.get(0).click();

        // Test if the opened page contains the keyword specified in configuration.properties
        // without case sensitivity
        String actualProductNameLowerCase = testAutomationPage
                .productNameElementOnProductPage
                .getText()
                .toLowerCase();
        Assert.assertTrue(actualProductNameLowerCase.contains(ConfigReader.getProperty("toSearchKeyword")));

        ReusableMethods.wait(3);
        Driver.closeDriver();
    }
}
