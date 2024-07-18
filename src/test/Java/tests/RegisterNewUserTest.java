package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterNewUser;


public class RegisterNewUserTest extends TestBase{
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = "A123456a";
    HomePage homePage;
    RegisterNewUser registerNewUser;
    @Test(priority = 1)
    public void userCanRegisterSuccessfully()
    {
        homePage = new HomePage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        String successRegister;
        successRegister = registerNewUser.successRegistration.getText();
        Assert.assertEquals(successRegister,"Your registration completed");
        homePage.logout();
    }
}
