package com.myproject.tests.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class TestBase {


    protected static WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentHtmlReporter extentHtmlReporter;
    protected ExtentTest extentTest;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
//        Code about extent reports
//        Report PATH= creates the html report right under test-output
        String currentDate = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir") + "/test-output/report/" + currentDate + "test_report.html";
//      Create html reporter using the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        Create extent report
        extentReports = new ExtentReports();
//        Add custom information
        extentReports.setSystemInfo("Environment", "Test Environment");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("Application", "TechProEd");
        extentReports.setSystemInfo("SQA", "John");
        extentHtmlReporter.config().setDocumentTitle("TechProEd BlueCar");
        extentHtmlReporter.config().setReportName("TechProEd Extent Report");
//        Attach html and extent reports
        extentReports.attachReporter(extentHtmlReporter);
//        Report is complete. Now we just need to create test using extentTest object
        extentTest = extentReports.createTest("My Project Extent Report", "This is for smoke test report");
        {
//        Done with configuration......

        }
    }
}
