package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterNewUser;

import java.time.Duration;

public class MyAccountTest extends TestBase{
    WebDriverWait wait;
    MyAccountPage myAccountPage;
    RegisterNewUser registerNewUser;
    HomePage homePage;
    LoginPage loginPage;
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);
    String newPassword = RandomStringUtils.random(14, true, true);
    RegisterNewUserTest registerNewUserTest;
    @Test(priority = 1)
    public void userCanChangePassword()
    {
        myAccountPage = new MyAccountPage(driver);
        homePage = new HomePage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        homePage.openMyAccountPage();
        myAccountPage.openChangePasswordLink();
        myAccountPage.changePassword(password,newPassword,newPassword);
        Assert.assertTrue(myAccountPage.passwordChangedSuccessfully.isDisplayed());
        Assert.assertEquals(myAccountPage.passwordChangedSuccessfully.getText(),"Password was changed");
        myAccountPage.closePasswordChangedSuccessfullyNotification();
    }
    @Test(priority = 2)
    public void userCanLogoutAndSignInWithNewPassword()
    {
        registerNewUser = new RegisterNewUser(driver);
        loginPage = new LoginPage(driver);
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.bar-notification.success")));
        homePage.logout();
        homePage.openLoginPage();
        loginPage.userLoginData(email,newPassword);
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
        homePage.logout();
    }
}
