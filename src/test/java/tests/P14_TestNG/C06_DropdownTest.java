package tests.P14_TestNG;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestAutomationFormPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class C06_DropdownTest {

    @Test
    public void dropdownTest(){
        //● Go to the https://testotomasyonu.com/form address.
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //	1. Select 5 using index from the Birth Date day options
        TestAutomationFormPage testAutomationFormPage = new TestAutomationFormPage();
        Select selectDay = new Select(testAutomationFormPage.dropdownMenuElementsList.get(0));
        selectDay.selectByIndex(5);

        //	2. Select April from the Birth Date month options using value
        Select selectMonth = new Select(testAutomationFormPage.dropdownMenuElementsList.get(1));
        selectMonth.selectByValue("nisan");

        //	3. Select 1990 from the Birth Date year options using visible text
        Select selectYear = new Select(testAutomationFormPage.dropdownMenuElementsList.get(2));
        selectYear.selectByVisibleText("1990");

        //	4. Print the selected values on the console
        System.out.println(selectDay.getFirstSelectedOption().getText() + "/" +
                selectMonth.getFirstSelectedOption().getText() + "/" +
                selectYear.getFirstSelectedOption().getText());

        //	5. Print all values (value) in the Month dropdown menu
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < selectMonth.getOptions().size(); i++) {
            stringList.add(selectMonth.getOptions().get(i).getText());
        }
        System.out.print(stringList);

        //	6. Test that the size of the Month Dropdown menu is 13
        Assert.assertEquals(selectMonth.getOptions().size(), 13);
    }
}
