package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BaseClass {

    protected WebDriver driver;
    ExtentSparkReporter htmlReporter;
    public static ExtentReports extent;
    //static ExtentTest logger;
    //ExtentTest test1,test2;
    @BeforeClass
    public void setupBrowser(){
        Reporter.log("Browser session started",true);
        //create ExtentReports and attach reporter(s)
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") +"/test-output/STMExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        //Driver initialization
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    /*@Test
    public void testTwo()
    {
        ExtentTest test1 = extent.createTest("ebay Search Test", "test to validate search box ");
        test1.log(Status.INFO, "Starting test case testTwo");
        driver.get("https://www.google.com");
        driver.manage().window().minimize();
        test1.pass("testTwo Passed");
        System.out.println(test1);
        System.out.println("working");
    }*/
    @AfterClass
    public void closingBrowser(){
        driver.quit();
        Reporter.log("Browser closed",true);
        //Extent report flush
        extent.flush();
        System.out.println("extent close");

    }

}
