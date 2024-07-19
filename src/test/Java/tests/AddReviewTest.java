package tests;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.util.Random;

public class AddReviewTest extends TestBase{
    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = RandomStringUtils.random(10, true, true);
    String title = (RandomStringUtils.random(50, true, true));
    String reviewText = (RandomStringUtils.random(455, true, true));
    Random rand = new Random();
    int rate = rand.nextInt(1,4);

    RegisterNewUser registerNewUser;
    AddReviewPage addReviewPage;
    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;


    @Test
    public void userCanAddReviewSuccessfully()
    {
        addReviewPage = new AddReviewPage(driver);
        registerNewUser = new RegisterNewUser(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        homePage.openRegistrationPage();
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);
        searchPage.selectFromAutoSuggest("Mac");
        productDetailsPage.openAddReviewPage();
        addReviewPage.enterReviewData(title,reviewText,rate);
        Assert.assertEquals(addReviewPage.reviewAddedSuccessfully.getText(),"Product review is successfully added.");
        driver.navigate().refresh();
        homePage.logout();
    }
}
