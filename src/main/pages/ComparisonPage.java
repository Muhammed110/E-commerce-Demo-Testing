package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComparisonPage extends PageBase{
    public ComparisonPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="a.clear-list")
    WebElement clearAllComparisonList;
    @FindBy(css="div.no-data")
    public WebElement comparisonPageEmpty;
    public void clickRemoveAllProducts()
    {
        clickBtn(clearAllComparisonList);
    }
}
