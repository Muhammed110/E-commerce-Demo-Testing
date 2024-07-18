package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparisonPage;
import pages.HomePage;
import pages.ProductListPage;

import java.time.Duration;

public class AddToComparisonTest extends TestBase{
    HomePage homePage;
    ProductListPage productListPage;
    ComparisonPage comparisonPage;
    WebDriverWait wait;
    @Test(priority = 1)
    public void userCanAddProductsToCompareSuccessfully()
    {
        homePage = new HomePage(driver);
        productListPage = new ProductListPage(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        homePage.selectCellPhones();
        productListPage.clickAddToCompare();
        wait.until(ExpectedConditions.visibilityOfAllElements(productListPage.addedToCompareNotificationBar));
        Assert.assertTrue(productListPage.addedToCompareNotificationBar.isDisplayed());
        productListPage.openComparisonPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/compareproducts");
    }
    @Test(priority = 2)
    public void userCanDeleteAllItemsFromTheComparison()
    {
        comparisonPage = new ComparisonPage(driver);
        comparisonPage.clickRemoveAllProducts();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElements(comparisonPage.comparisonPageEmpty));
        Assert.assertEquals(comparisonPage.comparisonPageEmpty.getText(),"You have no items to compare.");

    }
}
