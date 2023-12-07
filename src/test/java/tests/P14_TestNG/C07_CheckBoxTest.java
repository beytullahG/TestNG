package tests.P14_TestNG;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestAutomationFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C07_CheckBoxTest {

    @Test
    public void test01(){
        // a. Go to the given web page: https://testotomasyonu.com/form
        Driver.getDriver().get("https://testotomasyonu.com/form");

        // b. Select the checkboxes for Backache and Palpitation
        TestAutomationFormPage testAutomationFormPage = new TestAutomationFormPage();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView();", testAutomationFormPage.palpitationElement);

        ReusableMethods.wait(1);
        testAutomationFormPage.backAcheElement.click();
        testAutomationFormPage.palpitationElement.click();

        // c. Test that the Backache and Palpitation checkboxes are selected
        Assert.assertTrue(testAutomationFormPage.backAcheElement.isSelected());
        Assert.assertTrue(testAutomationFormPage.palpitationElement.isSelected());

        // d. Test that the Diabetes and Epilepsy checkboxes are not selected
        Assert.assertFalse(testAutomationFormPage.diabetesElement.isSelected());
        Assert.assertFalse(testAutomationFormPage.epilepsyElement.isSelected());

        Driver.closeDriver();
    }
}
