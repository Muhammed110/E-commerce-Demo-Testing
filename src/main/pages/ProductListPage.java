package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductListPage extends PageBase{
    public ProductListPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait;
    @FindBy(css="button.button-2.add-to-compare-list-button")
    List<WebElement> addToCompareBtn;
    @FindBy(css="div.bar-notification.success")
    public WebElement addedToCompareNotificationBar;
    @FindBy(linkText = "product comparison")
    WebElement productComparisonBtn;

    public void clickAddToCompare()
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        addToCompareBtn.get(0).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));
        addToCompareBtn.get(1).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));
        addToCompareBtn.get(2).click();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));

    }
    public void openComparisonPage()
    {
        clickBtn(productComparisonBtn);
    }
}
