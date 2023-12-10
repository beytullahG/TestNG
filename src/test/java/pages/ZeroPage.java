package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class ZeroPage {
    public ZeroPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//i[@class='icon-signin']")
    public WebElement signInButtonMainPage;
    @FindBy(id = "user_login")
    public WebElement loginBox;
    @FindBy(id = "user_password")
    public WebElement passwordBox;
    @FindBy(xpath = "//input[@type='submit']")
    public WebElement signInButtonSecondPage;
    @FindBy(xpath = "//strong[text()='Online Banking']")
    public WebElement onlineBankingLink;
    @FindBy(id = "pay_bills_link")
    public WebElement payBillsLink;
    @FindBy(xpath = "//*[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrencyLink;
    @FindBy(id = "pc_currency")
    public WebElement pcCurrencyDropdownElement;



}
