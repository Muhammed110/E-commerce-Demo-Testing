package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterNewUser extends PageBase {
    public RegisterNewUser(WebDriver driver) {
        super(driver);
    }
    public void enterUserData(int gender,String firstName, String lastName, int day, int month, String year,
                              String email, String companyName, String password, String confirmPassword)
    {
        if (gender == 1)
            clickBtn(genderMaleRdBtn);
        else if (gender == 0)
            clickBtn(genderFemaleRdBtn);
        typeText(userFirstName,firstName);
        typeText(userLastName,lastName);
        Select selectDay = new Select(dateOfBirthDay);
        selectDay.selectByIndex(day);
        Select selectMonth = new Select(dateOfBirthMonth);
        selectMonth.selectByIndex(month);
        Select selectYear = new Select(dateOfBirthYear);
        selectYear.selectByValue(year);
        typeText(userEmail,email);
        typeText(this.companyName,companyName);
        typeText(userPassword,password);
        typeText(userConfirmPassword,confirmPassword);
        clickBtn(registerBtn);
    }

    @FindBy(id ="gender-male")
    WebElement genderMaleRdBtn;
    @FindBy(id ="gender-female")
    WebElement genderFemaleRdBtn;
    @FindBy(id ="FirstName")
    WebElement userFirstName;
    @FindBy(id ="LastName")
    WebElement userLastName;
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthDay;
    @FindBy(name = "DateOfBirthMonth")
    WebElement dateOfBirthMonth;
    @FindBy(name = "DateOfBirthYear")
    WebElement dateOfBirthYear;
    @FindBy(id ="Email")
    WebElement userEmail;
    @FindBy(id ="Company")
    WebElement companyName;
    @FindBy(id ="Password")
    WebElement userPassword;
    @FindBy(id ="ConfirmPassword")
    WebElement userConfirmPassword;
    @FindBy(id ="register-button")
    WebElement registerBtn;
    @FindBy(css = "div.result")
    public WebElement successRegistration;

}
