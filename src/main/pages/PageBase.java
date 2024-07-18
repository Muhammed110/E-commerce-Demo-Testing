package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class PageBase {
    protected WebDriver driver;

    //Create constructor for PageBase Class
    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    protected static void clickBtn(WebElement element)
    {
        element.click();
    }
    protected static void typeText(WebElement element,String text)
    {
        element.sendKeys(text);
    }
    protected void scrollToElement(WebElement element)
    {
        new Actions(driver).scrollToElement(element).perform();
    }
    protected void waitUntilFinishLoading()
    {
        WebDriverWait wait;
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));
    }



}
