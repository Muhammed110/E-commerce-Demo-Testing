package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.WishListPage;

import java.time.Duration;

public class WishListTest extends TestBase {
    WebDriverWait wait;
    WishListPage wishListPage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    @Test(priority = 1)
    public void userCanAddItemsToWishListSuccessfully()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage.selectFromAutoSuggest("Mac");
        productDetailsPage.addToWishList();
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfAllElements(productDetailsPage.itemAddedToWishListNotification));
        Assert.assertTrue(productDetailsPage.itemAddedToWishListNotification.isDisplayed());
    }
    @Test(priority = 2)
    public void userCanRemoveItemsFromWishListSuccessfully()
    {
        wishListPage = new WishListPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.openWishListPageFromNotificationBar();
        wishListPage.removeFromCart();
        Assert.assertTrue(wishListPage.wishListEmptyNotifications.isDisplayed());
    }
}
