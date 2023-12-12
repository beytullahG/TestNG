package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseReport {
    // Initiate the Extent report
    protected static ExtentReports extentReports; // Initialize the Extent report
    protected static ExtentTest extentTest; // Record information such as pass or fail for tests and take screenshots if needed
    protected static ExtentHtmlReporter extentHtmlReporter; // Organize the HTML report

    // Before starting the test process (before the test method, not before each test method)
    @BeforeTest(alwaysRun = true) // alwaysRun: always execute.
    public void setUpTest() {
        extentReports = new ExtentReports(); // Initialize reporting
        // After creating the report, specify where you want your report to be added.
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "/test-output/Report"+date+".html";
        // Starting the report we want to create (in HTML format) and specifying the file path with filePath.
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);

        // You can add the information you want here.
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Beytullah Gorgulu");
        extentHtmlReporter.config().setDocumentTitle("TestNG Test");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }

    // After each test method, if there is an error in the test, take a screenshot and add it to the report
    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult result) throws IOException {

        if (result.getStatus() == ITestResult.FAILURE) { // if the test result is a failure
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // if the test is skipped without being executed
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore those
        }
        Driver.closeDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }

}