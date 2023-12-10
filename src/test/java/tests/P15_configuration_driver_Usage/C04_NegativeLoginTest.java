package tests.P15_configuration_driver_Usage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegativeLoginTest {

    /*
     1- Go to the homepage https://www.testotomasyonu.com/
     2- Click on the "login" link
     3- Create 3 different test methods.
    	- valid email, invalid password
    	- invalid email, valid password
    	- invalid email, invalid password.
    4- Login by clicking the Login button
    5- Test that login cannot be made succesfully
    */
    @Test
    public void invalidPasswordTest() {
        // 1- Go to the homepage https://www.testotomasyonu.com/
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2- Click on the "account" link
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.accountLink.click();
        // 3- Create 3 different test methods.
        //	- valid email, invalid password
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty("toValidEmail"));
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
        //4- Login by clicking the Login button
        testAutomationPage.loginButton.click();
        //5- Test that login cannot be made succesfully
        Assert.assertTrue(testAutomationPage.emailBox.isDisplayed());
    }


    @Test
    public void invalidEmailTest() {
        // 1- Go to the homepage https://www.testotomasyonu.com/
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2- Click on the "account" link
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.accountLink.click();
        // 3- Create 3 different test methods.
        //	- invalid email, valid password
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty("toValidPassword"));
        //4- Login by clicking the Login button
        testAutomationPage.loginButton.click();
    }

    @Test(priority = 5)
    public void invalidEmailInvalidPasswordTest() {
        // 1- Go to the homepage https://www.testotomasyonu.com/
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        // 2- Click on the "account" link
        TestAutomationPage testAutomationPage = new TestAutomationPage();
        testAutomationPage.accountLink.click();
        // 3- Create 3 different test methods.
        //	- invalid email, invalid password
        testAutomationPage.emailBox.sendKeys(ConfigReader.getProperty("toInvalidEmail"));
        testAutomationPage.passwordBox.sendKeys(ConfigReader.getProperty("toInvalidPassword"));
        //4- Login by clicking the Login button
        testAutomationPage.loginButton.click();
        //5- Test that login cannot be made succesfully
        Assert.assertTrue(testAutomationPage.emailBox.isDisplayed());

        //6- Close the page
        Driver.closeDriver();
    }
}
