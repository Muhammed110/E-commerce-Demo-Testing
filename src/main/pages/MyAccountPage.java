package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyAccountPage extends PageBase{
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;
    @FindBy(id="OldPassword")
    WebElement oldPassword;
    @FindBy(id="NewPassword")
    WebElement newPassword;
    @FindBy(id="ConfirmNewPassword")
    WebElement confirmNewPassword;
    @FindBy(css = "button.button-1.change-password-button")
    WebElement changePasswordBtn;
    @FindBy(css = "p.content")
    public WebElement passwordChangedSuccessfully;
    @FindBy(css = "span.close")
    WebElement closePasswordChangedSuccessfully;
    public void openChangePasswordLink()
    {
        clickBtn(changePasswordLink);
    }

    public void changePassword(String olPassword,String nePassword,String conNewPassword)
    {
        typeText(oldPassword,olPassword);
        typeText(newPassword,nePassword);
        typeText(confirmNewPassword,conNewPassword);
        clickBtn(changePasswordBtn);
    }
    public void closePasswordChangedSuccessfullyNotification()
    {
        clickBtn(closePasswordChangedSuccessfully);
    }


}
