package tests.P17_crossBrowserRunnableTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationFormPage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C02 extends TestBaseCross {

    /*
        It is important not to write tests that will run on cross-browser under existing test packages.
        If you want to add a test method to tests that will run on cross-browser,
        you should move it to the CrossBrowser package and make the following changes:
        1- Extend TestBaseCross.
        2- Use the driver object from TestBaseCross instead of Driver.getDriver().
        3- Since the Page classes are defined with Driver.getDriver(),
           you cannot use them. You must perform locates using the driver object in the test method.
     */

    @Test
    public void dropdownTest(){
        //● Go to the https://testautomationu.com/form address.
        driver.get("https://testautomationu.com/form");
        //	1. Select '5' using index from the birth date day options
        List<WebElement> dropdownMenuElementsList =
                driver.findElements(By.xpath("//select[@class='form-control']"));
        Select selectDay = new Select(dropdownMenuElementsList.get(0));
        selectDay.selectByIndex(5);
        //	2. Select 'April' from the birth date month options using value
        Select selectMonth = new Select(dropdownMenuElementsList.get(1));
        selectMonth.selectByValue("nisan");
        //	3. Select '1990' from the birth date year options using visible text
        Select selectYear = new Select(dropdownMenuElementsList.get(2));
        selectYear.selectByVisibleText("1990");
        //	4. Print the selected values on the console
        System.out.println(selectDay.getFirstSelectedOption().getText() + "/" +
                selectMonth.getFirstSelectedOption().getText()+"/"+
                selectYear.getFirstSelectedOption().getText());
        //	5. Print all values (value) in the month dropdown menu
        List<String> monthsList = ReusableMethods.convertToStringList(selectMonth.getOptions());
        System.out.println(monthsList);
        //	6. Test that the size of the Month Dropdown menu is 13
        Assert.assertEquals(selectMonth.getOptions().size(),13);

    }
}
