package tests.P17_testNGReports_dataProvider_CrossBrowserTesting;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import utilities.TestBaseReport;

public class C02_DataProviderUsage extends TestBaseReport {


    @DataProvider
    public static Object[][] searchProductsDataProvider() {
        // data provider is a method that returns a two-dimensional object array
        String[][] searchProducts ={{"phone"},{"java"},{"dress"},{"nutella"},{"chair"},{"tea"}};

        return searchProducts;
    }

    @Test(dataProvider = "searchProductsDataProvider")
    public void searchWithDataProvider(String searchedProduct){
        extentTest = extentReports.createTest("Data Provider Test","User should be able to search for the specified product list");

        TestAutomationPage testOtomasyonuPage = new TestAutomationPage();
        // Go to the testautomationu homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("User goes to the testautomationu homepage");

        // Search for the specified product in the given list
        testOtomasyonuPage.searchBox.sendKeys(searchedProduct + Keys.ENTER);
        extentTest.info("User searches for "+ searchedProduct);
        ReusableMethods.wait(1);

        // Test if a product is found for each product
        int actualProductCount = testOtomasyonuPage.foundProductElementsList.size();
        Assert.assertTrue(actualProductCount > 0);
        extentTest.pass("User tests if a product is found for "+ searchedProduct);
    }
}
