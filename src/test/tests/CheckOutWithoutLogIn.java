package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.time.Duration;
import java.util.Random;

public class CheckOutWithoutLogIn extends TestBase{
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    OrderDetailsPage orderDetailsPage;
    WebDriverWait wait;
    String firstName = (RandomStringUtils.random(15, true, false));
    String lastName = RandomStringUtils.random(15, true, false);
    String email = (RandomStringUtils.random(8, true, true)+"@bcd.com");
    Random rand = new Random();

    int country = rand.nextInt(1,241);
    String city = RandomStringUtils.random(20, true, false);

    String address = (RandomStringUtils.random(40, true, true));
    String zipCode = RandomStringUtils.random(5, true, false);
    String phoneNumber = RandomStringUtils.random(11, false, true);
    int shipmentMethod = rand.nextInt(0,3);




    @Test
    public void userCanCompleteOrdersWithoutRegistration()
    {
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        searchPage.selectFromAutoSuggest("Mac");
        productDetailsPage.addToCart();
        wait.until(ExpectedConditions.visibilityOfAllElements(productDetailsPage.addedToCartSuccessfully));
        productDetailsPage.openShoppingCartPage();
        shoppingCartPage.agreeTermsClick();
        shoppingCartPage.clickCheckOut();
        checkOutPage.clickCheckOutAsAGuestBtn();
        checkOutPage.enterUserData(firstName,lastName,email,country,city,address,zipCode,phoneNumber);
        checkOutPage.chooseShippingMethod(shipmentMethod);
        checkOutPage.choosePaymentMethod(0);
        checkOutPage.confirmTheOrder();
        Assert.assertTrue(checkOutPage.orderHasBeenSuccessfullyProcessedMsg.isDisplayed());
        Assert.assertTrue(checkOutPage.orderHasBeenSuccessfullyProcessedMsg.getText().contains("Your order has been successfully processed!"));
        checkOutPage.openOrderDetailsPage();
        orderDetailsPage.clickOnDownloadAsPDFBtn();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
