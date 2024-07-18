package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class ReferToFriendTest extends TestBase{
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);
    String friendEmail = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String msgToFriend = (RandomStringUtils.random(100, true, true));
    SearchPage searchPage;
    ReferToFriendPage referToFriendPage;
    ProductDetailsPage productDetailsPage;
    RegisterNewUser registerNewUser;
    HomePage homePage;

    @Test
    public void userCanReferProductToFriendSuccessfully()
    {
        referToFriendPage = new ReferToFriendPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        searchPage.selectFromAutoSuggest("Mac");
        productDetailsPage.openReferToFriendPage();
        referToFriendPage.referToYourFriend(friendEmail,msgToFriend);
        Assert.assertEquals(referToFriendPage.emailSentSuccessfullyMessage.getText(),"Your message has been sent.");
        homePage.logout();
    }
}
