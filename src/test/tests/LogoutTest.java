package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterNewUser;

public class LogoutTest extends TestBase{
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);
    RegisterNewUser registerNewUser;
    HomePage homePage;
    @Test
    public void userCanLogoutSuccessfully()
    {
        homePage = new HomePage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        homePage.logout();
        Assert.assertTrue(homePage.loginLink.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
    }
}
