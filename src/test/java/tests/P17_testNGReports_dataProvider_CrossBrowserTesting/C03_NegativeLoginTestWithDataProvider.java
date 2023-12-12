package tests.P17_testNGReports_dataProvider_CrossBrowserTesting;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_NegativeLoginTestWithDataProvider {

    @AfterTest
    public void tearDown(){
        Driver.closeDriver();
    }

    @DataProvider
    public static Object[][] userInformationDP() {
        String[][] userInformation = {
                {"user1", "12345"},
                {"user2", "23456"},
                {"user3", "34567"},
                {"user4", "45678"},
                {"user5", "56789"}
        };
        return userInformation;
    }

    @Test(dataProvider = "userInformationDP")
    public void multipleNegativeLoginTest(String username, String password) {

        // Go to the testautomationu homepage
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        // Click on the account link
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.accountLink.click();

        // Test that login cannot be performed for all values
        // given as username and password in the provided list
        testAutomationPage.emailBox.sendKeys(username);
        testAutomationPage.passwordBox.sendKeys(password);
        testAutomationPage.loginButton.click();
        Assert.assertTrue(testAutomationPage.emailBox.isDisplayed());
        // user1   12345
        // user2   23456
        // user3   34567
        // user4   45678
        // user5   56789
    }
}
