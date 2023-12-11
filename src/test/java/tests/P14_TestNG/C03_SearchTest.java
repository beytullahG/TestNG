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


    // make the necessary settings
    // Create 3 test methods
    // 1- Go to testotomasyonu homepage and
    //    test that you went to the correct address
    // 2- Search for phone and
    //    test that the product can be found in the search result
    // 3- Click on the first product and
    //    On the opened product page, test whether the product name contains phone without being case sensitive
    WebDriver driver;

    @Test
    public void testAutomationTest() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 1- Go to testotomasyonu homepage and
        //    test that you went to the correct address
        driver.get("https://www.testotomasyonu.com");

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl);
    }

    @Test(dependsOnMethods = "testAutomationTest")
    public void searcTest() {
        // 2- Search for phone and
        //    test that the product can be found in the search result
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unexpectedSonucYazisi = "0 Products Found";
        String actualSonucyazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(unexpectedSonucYazisi, actualSonucyazisi);
    }

    @Test(dependsOnMethods = "searcTest")
    public void productNameTest() {
        // 3- Click on the first product and
        //    On the opened product page, test whether the product name contains phone without being case sensitive

        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]"))
                .click();

        WebElement urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));

        String expectedIsimIcerik = "phone";
        String actualIsimKucukHarf = urunIsimElementi.getText().toLowerCase();

        Assert.assertTrue(actualIsimKucukHarf.contains(expectedIsimIcerik));

        driver.close();
    }
}