package tests.P14_TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_SearchTest {

    // Make the necessary configurations
    // Create 3 test methods
    // 1- Go to the test automation homepage
    //    and test that we have reached the correct address
    // 2- Perform a search for "phone"
    //    and test that products are found in the search results
    // 3- Click on the first product and verify that the product page
    //    contains the word "phone" in a case-insensitive manner
    WebDriver driver;

    @Test
    public void testAutomationHomepage(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1- Go to the test automation homepage
        //    and test that we have reached the correct address
        driver.get("https://www.testotomasyonu.com");

        String expectedUrl ="https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Test(dependsOnMethods = "testAutomationHomepage")
    public void searchTest(){
        // 2- Perform a search for "phone"
        //    and test that products are found in the search results
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        WebElement searchResultElement = driver.findElement(By.className("product-count-text"));

        String unexpectedResultText = "0 Products Found";
        String actualResultText = searchResultElement.getText();

        Assert.assertNotEquals(unexpectedResultText, actualResultText);
    }

    @Test(dependsOnMethods = "searchTest")
    public void productNameTest(){
        // 3- Click on the first product and verify that the product page
        //    contains the word "phone" in a case-insensitive manner
        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();

        WebElement productNameElement = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedProductNameContent = "phone";
        String actualProductNameLowercase = productNameElement.getText().toLowerCase();

        Assert.assertTrue(actualProductNameLowercase.contains(expectedProductNameContent));

        driver.close();
    }
}