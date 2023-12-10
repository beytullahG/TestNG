package tests.P15_configuration_driver_Usage;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebuniversityPage;
import utilities.Driver;
import utilities.ReusableMethods;
import com.github.javafaker.Faker;

public class C01_WebuniversityTest {

    @Test
    public void negativeLoginTest() {
        //1. Go to the address "http://webdriveruniversity.com/"
        Driver.getDriver().get("http://webdriveruniversity.com/");

        //2. Scroll down to "Login Portal"
        WebuniversityPage webuniversityPage = new WebuniversityPage();
        // Actions actions = new Actions(Driver.getDriver());
        // actions.sendKeys(Keys.PAGE_DOWN);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", webuniversityPage.loginElement);

        //3. Click on "Login Portal"
        webuniversityPage.loginElement.click();

        //4. Switch to the other window
        ReusableMethods.switchPageByTitle("WebDriver | Login Portal");

        //5. Enter random values into the "username" and "password" fields
        Faker faker = new Faker();
        webuniversityPage.usernameElement.sendKeys(faker.name().username());
        webuniversityPage.passwordElement.sendKeys(faker.internet().password());

        //6. Click the "login" button
        webuniversityPage.loginButtonElement.click();

        //7. Test that the text in the popup is "validation failed"
        ReusableMethods.wait(1);
        String expectedAlertText = "validation failed";
        String actualAlertText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualAlertText, expectedAlertText);

        //8. Click "Ok" to close the popup
        Driver.getDriver().switchTo().alert().accept();

        //9. Go back to the first page
        ReusableMethods.switchPageByTitle("WebDriverUniversity.com");

        //10. Test that you have returned to the first page
        Assert.assertTrue(Driver.getDriver().getTitle().contains("WebDriverUniversity.com"));

        //11. Close the page
        Driver.quitDriver();

    }
}
