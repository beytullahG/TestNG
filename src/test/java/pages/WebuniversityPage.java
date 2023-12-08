package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class WebuniversityPage {
    public WebuniversityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//*[@*='section-title'])[2]")
    public WebElement loginElement;

    @FindBy(id="text")
    public WebElement usernameElement;
    @FindBy(id="password")
    public WebElement passwordElement;
    @FindBy(id="login-button")
    public WebElement loginButtonElement;

}
