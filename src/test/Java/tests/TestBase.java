package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;
import org.testng.xml.internal.Parser;
import utilities.Helper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestBase extends AbstractTestNGCucumberTests {
    public static WebDriver driver;
    @BeforeSuite
    public void startDriver()
    {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void screenshotOnFail(ITestResult result)
    {
        if (result.getStatus() == ITestResult.FAILURE)
        {
            System.out.println("Fails method \n Taking screenshot");
            Helper.captureScreenshot(driver,result.getName());
        }
    }
    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }

}
