package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutPage extends PageBase{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }
    WebDriverWait wait;
    @FindBy(css ="button.button-1.checkout-as-guest-button")
    WebElement checkOutAsAGuestBtn;
    @FindBy(id="BillingNewAddress_FirstName")
    WebElement firstName;
    @FindBy(id="BillingNewAddress_LastName")
    WebElement lastName;
    @FindBy(id="BillingNewAddress_Email")
    WebElement email;
    @FindBy(id="BillingNewAddress_CountryId")
    WebElement country;
    @FindBy(id="BillingNewAddress_City")
    WebElement city;
    @FindBy(id="BillingNewAddress_Address1")
    WebElement address1;
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    WebElement zipCode;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    WebElement phoneNumber;
    @FindBy(css="button.button-1.new-address-next-step-button")
    WebElement continueBillingAddressBtn;
    @FindBy(id="shippingoption_0")
    WebElement groundRdBtn;
    @FindBy(id="shippingoption_1")
    WebElement nextDayAirRdBtn;
    @FindBy(id="shippingoption_2")
    WebElement nd2DayAirRdBtn;
    @FindBy(css="button.button-1.shipping-method-next-step-button")
    WebElement continueShippingMethodBtn;
    @FindBy(id="paymentmethod_0")
    WebElement chequeOrMoneyOrder;
    @FindBy(id="paymentmethod_1")
    WebElement creditCardMethod;
    @FindBy(css="button.button-1.payment-method-next-step-button")
    WebElement continuePaymentMethodBtn;
    @FindBy(css="button.button-1.payment-info-next-step-button")
    WebElement continuePaymentInfoBtn;
    @FindBy(css="button.button-1.confirm-order-next-step-button")
    WebElement confirmOrderBtn;
    @FindBy(css = "div.page.checkout-page.order-completed-page")
    public WebElement orderHasBeenSuccessfullyProcessedMsg;
    @FindBy(css = "button.button-1.order-completed-continue-button")
    WebElement continueOrderIsCompletedBtn;
    @FindBy(linkText = "Click here for order details.")
    WebElement viewOrderDetails;

    public void clickCheckOutAsAGuestBtn()
    {
        clickBtn(checkOutAsAGuestBtn);
    }
    public void enterUserData(String userFirstName,String userLastName,
                              String userEmail,int userCountry,String userCity,String userAddress,String userZipCode,String userPhone)
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        Select select = new Select(country);
        typeText(firstName,userFirstName);
        typeText(lastName,userLastName);
        typeText(email,userEmail);
        select.selectByIndex(userCountry);
        typeText(city,userCity);
        typeText(address1,userAddress);
        typeText(zipCode,userZipCode);
        typeText(phoneNumber,userPhone);
        clickBtn(continueBillingAddressBtn);
    }
    public void chooseShippingMethod(int shipmentMethod)
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(groundRdBtn));
        if (shipmentMethod == 0)
            clickBtn(groundRdBtn);
        else if (shipmentMethod == 1)
            clickBtn(nextDayAirRdBtn);
        else if (shipmentMethod == 2)
            clickBtn(nd2DayAirRdBtn);
        clickBtn(continueShippingMethodBtn);
    }
    public void choosePaymentMethod(int paymentMethod)
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(chequeOrMoneyOrder));
        if (paymentMethod == 0)
            clickBtn(chequeOrMoneyOrder);
        else if (paymentMethod == 1)
            clickBtn(creditCardMethod);
        clickBtn(continuePaymentMethodBtn);
    }
    public void confirmTheOrder()
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(continuePaymentInfoBtn));
        clickBtn(continuePaymentInfoBtn);
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
        clickBtn(confirmOrderBtn);
        wait.until(ExpectedConditions.elementToBeClickable(continueOrderIsCompletedBtn));
    }
    public void openOrderDetailsPage()
    {
        clickBtn(viewOrderDetails);
    }
    public void enterRegisteredUserDate(int userCountry,String userCity,String userAddress,String userZipCode,String userPhone)
    {
        wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(firstName));
        Select select = new Select(country);
        select.selectByIndex(userCountry);
        typeText(city,userCity);
        typeText(address1,userAddress);
        typeText(zipCode,userZipCode);
        typeText(phoneNumber,userPhone);
        clickBtn(continueBillingAddressBtn);
    }

}
