package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> convertToStringList(List<WebElement> elementList){

        List<String> stringList = new ArrayList<>();

        for (WebElement each : elementList) {
            stringList.add(each.getText());
        }

        return stringList;
    }

    public static void wait(int seconds){

        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void switchPageByTitle(String targetPageTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {
            String eachTitle = Driver.getDriver().switchTo().window(each).getTitle();
            if (eachTitle.equals(targetPageTitle)) {
                break;
            }
        }
    }

    public static String getSecondPageHandle(WebDriver driver, String firstPageHandle) {

        Set<String> allWindowHandles = driver.getWindowHandles();

        allWindowHandles.remove(firstPageHandle);

        for (String each : allWindowHandles) {
            return each;
        }

        return null; // We know this line will never be executed; it is just to suppress Java's concerns.
    }

    public static void captureFullPageScreenshot(WebDriver driver){
        // Capture and save a screenshot of the entire page

        // Step 1: Create a TakesScreenshot object
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Step 2: Create a File for the location to save the screenshot
        // To ensure that each new screenshot does not overwrite the previous one,
        // let's make the file path dynamic by adding a date label
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter preferredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/fullPageScreenshot" +
                localDateTime.format(preferredFormat) +
                ".jpg";

        File fullPageScreenshot = new File(dynamicFilePath);

        // Step 3: Capture the screenshot using the TakesScreenshot object and save it to a temporary file
        File temporaryFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file location
        try {
            FileUtils.copyFile(temporaryFile, fullPageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.wait(5);
    }

    public static void captureFullPageScreenshot(String testName, WebDriver driver){
        // Capture and save a screenshot of the entire page

        // Step 1: Create a TakesScreenshot object
        TakesScreenshot screenshot = (TakesScreenshot) driver;

        // Step 2: Create a File for the location to save the screenshot
        // To ensure that each new screenshot does not overwrite the previous one,
        // let's make the file path dynamic by adding a date label
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter preferredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/" +
                testName +
                localDateTime.format(preferredFormat) +
                ".jpg";

        File fullPageScreenshot = new File(dynamicFilePath);

        // Step 3: Capture the screenshot using the TakesScreenshot object and save it to a temporary file
        File temporaryFile = screenshot.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file location
        try {
            FileUtils.copyFile(temporaryFile, fullPageScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.wait(5);
    }

    public static void captureWebElementScreenshot(WebElement targetWebElement){

        // Step 1: Locate the WebElement for which we want to capture a screenshot

        // Step 2: Create a File for the location to save the screenshot
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter preferredFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dynamicFilePath = "target/screenshots/targetWebElementScreenshot" +
                localDateTime.format(preferredFormat) +
                ".jpg";

        File targetWebElementScreenshot = new File(dynamicFilePath);

        // Step 3: Capture the screenshot of the WebElement and save it to a temporary file
        File temporaryFile = targetWebElement.getScreenshotAs(OutputType.FILE);

        // Step 4: Copy the temporary file to the actual file location
        try {
            FileUtils.copyFile(temporaryFile, targetWebElementScreenshot);
        } catch (IOException e) {
            System.out.println("Unable to copy the screenshot");
            throw new RuntimeException(e);
        }
    }
}
