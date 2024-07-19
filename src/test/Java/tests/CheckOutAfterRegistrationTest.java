package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class CheckOutAfterRegistrationTest extends TestBase{
    HomePage homePage;
    RegisterNewUser registerNewUser;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    OrderDetailsPage orderDetailsPage;
    Random rand = new Random();

    int country = rand.nextInt(1,241);
    String city = RandomStringUtils.random(20, true, false);

    String address = (RandomStringUtils.random(40, true, true));
    String zipCode = RandomStringUtils.random(5, true, false);
    String phoneNumber = RandomStringUtils.random(11, false, true);
    int shipmentMethod = rand.nextInt(0,3);


    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);

    @Test(priority = 1)
    public void userCanRegisterAndGoToPDPSuccessfully()
    {
        homePage = new HomePage(driver);
        registerNewUser = new RegisterNewUser(driver);
        searchPage = new SearchPage(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        searchPage.selectFromAutoSuggest("Mac");
    }
    @Test(priority = 2)
    public void userCanCompleteCheckOutSuccessfully()
    {
        productDetailsPage = new ProductDetailsPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        checkOutPage = new CheckOutPage(driver);
        orderDetailsPage = new OrderDetailsPage(driver);
        productDetailsPage.addToCart();
        productDetailsPage.openShoppingCartPage();
        shoppingCartPage.agreeTermsClick();
        shoppingCartPage.clickCheckOut();
        checkOutPage.enterRegisteredUserDate(country,city,address,zipCode,phoneNumber);
        checkOutPage.chooseShippingMethod(shipmentMethod);
        checkOutPage.choosePaymentMethod(0);
        checkOutPage.confirmTheOrder();
        Assert.assertTrue(checkOutPage.orderHasBeenSuccessfullyProcessedMsg.isDisplayed());
        Assert.assertTrue(checkOutPage.orderHasBeenSuccessfullyProcessedMsg.getText().contains("Your order has been successfully processed!"));
        checkOutPage.openOrderDetailsPage();
        orderDetailsPage.clickOnPrintOrderBtn();
        homePage.logout();
    }

}
