package tests.P15_configuration_driver_Usage;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTest {

    @Test(groups = {"smoke" , "regression"})
    public void positiveLoginTest() {

        // 1- Go to the homepage https://www.testotomasyonu.com/
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2- Click on the "account" link
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.accountLink.click();
        // 3- Enter a valid email as the user's email
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        // 4- Enter a valid password as the user's password
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty("toValidPassword"));
        // 5- Login by clicking the Login button
        testAutomationPage.loginButton.click();
        // 6- Test if the login is successful
        Assert.assertTrue(testAutomationPage.logoutLink.isDisplayed());
        // 7- Close the page
        Driver.closeDriver();


    }
}
