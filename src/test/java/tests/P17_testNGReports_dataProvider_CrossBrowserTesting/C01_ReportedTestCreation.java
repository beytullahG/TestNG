package tests.P17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class C01_ReportedTestCreation extends TestBaseReport {


    @Test
    public void searchTest() {
        extentTest = extentReports.createTest("Search Test", "User tests if the correct search is performed by searching for the specified keyword");
        // Go to the testotomasyonu homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("User goes to the testotomasyonu homepage");

        // Perform a search for the specified search keyword
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.searchBox.sendKeys(ConfigReader.getProperty("toSearchKeyword") + Keys.ENTER);
        extentTest.info("User performs a search for the specified search keyword");

        // Test if a product is found in the search results
        assertFalse(testAutomationPage.foundProductElementsList.isEmpty());
        extentTest.pass("User tests if a product is found in the search results");
        ReusableMethods.wait(1);

        // Click on the first product
        testAutomationPage.foundProductElementsList.get(0).click();
        extentTest.info("User clicks on the first product");

        // Test if the product name on the opened product page
        // contains the specified search keyword without case sensitivity
        assertTrue(testAutomationPage.productNameElementOnProductPage
                .getText().toLowerCase().contains(ConfigReader.getProperty("toSearchKeyword")));

        extentTest.pass("User tests if the product name on the opened product page\ncontains the specified search keyword without case sensitivity");

        Driver.closeDriver();
        extentTest.info("User closes the page");
    }
}
