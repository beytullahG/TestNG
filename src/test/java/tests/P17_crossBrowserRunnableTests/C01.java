package tests.P17_crossBrowserRunnableTests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.ReusableMethods;
import utilities.TestBaseCross;

import java.util.List;

public class C01 extends TestBaseCross {

    @Test
    public void searchTest(){

        driver.get(ConfigReader.getProperty("toUrl"));

        // Perform a search for "phone"
        WebElement searchBox = driver.findElement(By.id("global-search"));
        searchBox.sendKeys("phone" + Keys.ENTER);

        // Test if a product is found in the search results
        List<WebElement> foundProductElementsList =
                driver.findElements(By.xpath("//div[@class= 'product-box my-2  py-1']"));

        int actualResultCount = foundProductElementsList.size();

        Assert.assertTrue(actualResultCount > 0);
    }
}
