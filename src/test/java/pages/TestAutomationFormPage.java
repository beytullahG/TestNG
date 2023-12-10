package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestAutomationFormPage {
    public TestAutomationFormPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@class='form-control']")
    public List<WebElement> dropdownMenuElementsList;

    @FindBy(id = "gridCheck4")
    public WebElement palpitationElement;

    @FindBy(id = "gridCheck5")
    public WebElement backAcheElement;

    @FindBy(id = "hastalikCheck2")
    public WebElement diabetesElement;

    @FindBy(id = "hastalikCheck7")
    public WebElement epilepsyElement;

}
