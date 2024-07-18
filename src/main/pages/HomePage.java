package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class HomePage extends PageBase{

    public HomePage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    WebDriverWait wait;
    public void openRegistrationPage()
    {
        clickBtn(registerLink);
    }
    public void openLoginPage()
    {
        clickBtn(loginLink);
    }
    public void openMyAccountPage()
    {
        clickBtn(myAccountLink);
    }

    public void openContactUsPage()
    {
        scrollToElement(footer);
        clickBtn(contactUsBtn);
    }

    public void changeCurrency(int number)
    {
        Select select = new Select(currency);
        select.selectByIndex(number);
    }
    public void logout()
    {
        clickBtn(logoutLink);
    }
    public void selectCellPhones()
    {
        action.moveToElement(electronicsMenu).build().perform();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElements(cellPhonesBtn));
        action.moveToElement(cellPhonesBtn).click().build().perform();
    }



    Actions action;
    @FindBy(css = "a.ico-register")
    WebElement registerLink;
    @FindBy(css = "a.ico-login")
    public WebElement loginLink;
    @FindBy(css = "a.ico-account")
    WebElement myAccountLink;
    @FindBy(css="div.footer")
    WebElement footer;
    @FindBy(xpath = "//a[@href='/contactus']")
    WebElement contactUsBtn;
    @FindBy(id="customerCurrency")
    WebElement currency;
    @FindBy(linkText="Electronics")
    WebElement electronicsMenu;
    @FindBy(linkText="Cell phones")
    WebElement cellPhonesBtn;
    @FindBy(css="a.ico-logout")
    public WebElement logoutLink;
}
