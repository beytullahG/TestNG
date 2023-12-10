package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestAutomationPage {

    public TestAutomationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-search")
    // @FindBy(xpath = "//form[@class='expanding-search-form ']")
    public WebElement searchBox;

    @FindBy(className = "product-count-text")
    public WebElement resultTextElement;

    @FindBy(xpath = "//div[@class= 'product-box my-2  py-1']")
    public List<WebElement> foundProductElementsList;

    @FindBy(xpath = "//div[@class=' heading-sm mb-4']")
    public WebElement productNameElementOnProductPage;

    @FindBy(xpath = "(//a[@class='e-cart'])[1]")
    public WebElement accountLink;

    @FindBy(xpath = "//*[@id='email']")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submitlogin")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutLink;

}
