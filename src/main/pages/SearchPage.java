package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait;

    @FindBy(id="small-searchterms")
    WebElement searchTextBox;
    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;
    @FindBy(id="ui-id-1")
    List<WebElement> dropDownSearch;
    @FindBy(css="h2.product-title")
    WebElement searchResultItem;
    @FindBy(css="div.product-name")
    public WebElement productName;
    public void enterSearchWord(String search)
    {
        typeText(searchTextBox,search);
    }
    public void clickSearch()
    {
        clickBtn(searchBtn);
    }
    public void clickOnProductInSearchResult()
    {
        clickBtn(searchResultItem);
    }
    public void selectFromAutoSuggest(String keyWord)
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        typeText(searchTextBox,keyWord);
        clickBtn(searchTextBox);
        searchTextBox.sendKeys(Keys.ARROW_DOWN);
        wait.until(ExpectedConditions.visibilityOfAllElements(dropDownSearch));
        clickBtn(dropDownSearch.get(0));
    }
}
