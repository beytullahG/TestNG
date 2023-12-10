package tests.P16_softAssertion_xmlFiles;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class C02_SoftAssertion {

    @Test
    public void softAssertionTest() {
        // 1. Go to the "http://zero.webappsecurity.com/" address
        Driver.getDriver().get(ConfigReader.getProperty("zeroUrl"));
        // 2. Verify that you are on the webappsecurity home page
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "http://zero.webappsecurity.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl, expectedUrl, "We are not on the homepage");
        // 3. Click on the Sign In button
        ZeroPage zeroPage = new ZeroPage();
        zeroPage.signInButtonMainPage.click();
        // 4. Enter "username" in the login box
        zeroPage.loginBox.sendKeys("username");
        // 5. Enter "password" in the password box
        zeroPage.passwordBox.sendKeys("password");
        // 6. Click on the Sign In button
        zeroPage.signInButtonSecondPage.click();
        // 7. Click on the Back button
        Driver.getDriver().navigate().back();
        // 8. Verify that login is successful
        softAssert.assertTrue(zeroPage.onlineBankingLink.isDisplayed());
        // 9. Click on the Online Banking menu
        zeroPage.onlineBankingLink.click();
        // 10. Go to the Pay Bills page
        zeroPage.payBillsLink.click();
        // 11. Click on the "Purchase Foreign Currency" button
        zeroPage.purchaseForeignCurrencyLink.click();
        // 12. Verify that the Currency dropdown menu is accessible
        softAssert.assertTrue(zeroPage.pcCurrencyDropdownElement.isEnabled());
        // 13. Select Eurozone from the "Currency" dropdown menu
        Select select = new Select(zeroPage.pcCurrencyDropdownElement);
        select.selectByValue("EUR");
        // 14. Verify that "Eurozone (euro)" is selected
        String expectedOption = "Eurozone (euro)";
        String actualSelectedOption = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualSelectedOption, expectedOption, "Eurozone could not be selected");
        // 15. Verify that there are 16 options in the dropdown menu
        int expectedMenuSize = 16;
        int actualMenuSize = select.getOptions().size();
        softAssert.assertEquals(actualMenuSize, expectedMenuSize);
        // 16. Verify that "Canada (dollar)" is in the dropdown menu
        List<WebElement> dropDownMenuListElement = select.getOptions();
        List<String> dropDownMenuListStr = new ArrayList<>();
        for (WebElement webElement : dropDownMenuListElement) {
            dropDownMenuListStr.add(webElement.getText());
        }
        softAssert.assertTrue(dropDownMenuListStr.contains("Canada (dollar)"));
        // 17. Close the page
        Driver.closeDriver();
    }
}
