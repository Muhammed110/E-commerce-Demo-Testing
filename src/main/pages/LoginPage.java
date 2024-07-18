package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "Email")
    WebElement userEmail;
    @FindBy(id="Password")
    WebElement userPassword;
    @FindBy(id="RememberMe")
    WebElement rememberMe;
    @FindBy(css="button.button-1.login-button")
    WebElement loginButton;
    public void userLoginData(String email, String password)
    {
        typeText(userEmail,email);
        typeText(userPassword,password);
        clickBtn(rememberMe);
        clickBtn(loginButton);
    }


}
