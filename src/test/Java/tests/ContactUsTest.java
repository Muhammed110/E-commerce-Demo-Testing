package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.RegisterNewUser;


public class ContactUsTest extends TestBase{

    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = "A123456a";
    String name = "Testing name";
    String message = "Hello, This is contact us testing message";
    ContactUsPage contactUsPage;
    HomePage homePage;
    RegisterNewUser registerNewUser;
    @Test
    public void userCanUseContactUsSuccessfully()
    {
        contactUsPage = new ContactUsPage(driver);
        homePage = new HomePage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        homePage.openContactUsPage();
        contactUsPage.enterContactUsDetails(message);
        Assert.assertEquals(contactUsPage.successfulSentMessage.getText(),"Your enquiry has been successfully sent to the store owner.");
        homePage.logout();
    }
}
