package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterNewUser;

public class LoginPageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    RegisterNewUser registerNewUser;
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);
    @Test
    public void userCanLoginSuccessfully()
    {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        homePage.logout();
        homePage.openLoginPage();
        loginPage.userLoginData(email,password);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
        homePage.logout();
    }

}
