package tests.P14_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverClassUsage {

    @Test
    public void test01() throws InterruptedException {

        // Go to the testotomasyonu homepage
        Driver.getDriver().get("https://www.testotomasyonu.com");

        // Enter "phone" in the search box and search
        WebElement searchElement = Driver.getDriver().findElement(By.id("global-search"));
        searchElement.sendKeys("phone" + Keys.ENTER);

        // Print the search results
        WebElement searchResultElement = Driver.getDriver().findElement(By.className("product-count-text"));
        System.out.println(searchResultElement.getText());

        Thread.sleep(5000);

        // Close the driver
        Driver.closeDriver();
    }
}
