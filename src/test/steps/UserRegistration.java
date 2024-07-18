package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import pages.HomePage;
import pages.RegisterNewUser;

import static tests.TestBase.driver;

public class UserRegistration {

    HomePage homePage;
    RegisterNewUser registerNewUser;

    String email = (RandomStringUtils.random(5, true, true)+"@bcd.com");
    String password = "A123456a";
    @Given("The user in the home page")
    public void the_user_in_the_home_page() {
        homePage = new HomePage(driver);
        homePage.openRegistrationPage();
    }
    @When("He clicks on register link")
    public void he_clicks_on_register_link() {
        registerNewUser = new RegisterNewUser(driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("register"));


    }
    @When("He enters his data")
    public void he_enters_his_data() {
        registerNewUser = new RegisterNewUser(driver);
        registerNewUser.enterUserData(1,"Muh","Test",1,10,
                "2000",email,"My Company", password,password);

    }
    @Then("The registration successfully page display")
    public void the_registration_successfully_page_display() {

        registerNewUser = new RegisterNewUser(driver);
        homePage = new HomePage(driver);
        Assert.assertEquals(registerNewUser.successRegistration.getText(),"Your registration completed");
        homePage.logout();
    }
}
