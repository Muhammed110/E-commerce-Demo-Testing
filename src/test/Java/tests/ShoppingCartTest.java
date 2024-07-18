package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.ShoppingCartPage;

import java.time.Duration;

public class ShoppingCartTest extends TestBase{
    WebDriverWait wait;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    @Test(priority = 1)
    public void userCanAddProductToCartSuccessfully()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        searchPage.selectFromAutoSuggest("Mac");
        productDetailsPage.addToCart();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));
        Assert.assertTrue(productDetailsPage.addedToCartSuccessfully.isDisplayed());
        productDetailsPage.openShoppingCartPage();
        wait.until(ExpectedConditions.attributeToBe(By.cssSelector("div.ajax-loading-block-window"),"style","display: none;"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cart");
    }
    @Test(priority = 2)
    public void userCanChangeProductQuantitySuccessfully()
    {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.changeQuantity();
        Assert.assertEquals(shoppingCartPage.totalPrice.getText(),"$18,000.00");
    }
    @Test(priority = 3)
    public void userCanRemoveElementsFromCartSuccessfully()
    {
        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeProductsFromCart();
        Assert.assertTrue(shoppingCartPage.cartEmpty.isDisplayed());
    }
}
