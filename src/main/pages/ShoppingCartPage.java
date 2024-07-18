package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="input.qty-input")
    WebElement productQuantity;
    @FindBy(css="button.remove-btn")
    WebElement removeProductFromTheCart;
    @FindBy(css="span.product-subtotal")
    public WebElement totalPrice;
    @FindBy(css = "div.no-data")
    public WebElement cartEmpty;
    @FindBy(id="termsofservice")
    WebElement agreeTerms;
    @FindBy(id="checkout")
    WebElement checkOutBtn;

    public void changeQuantity()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitUntilFinishLoading();
        js.executeScript("arguments[0].setAttribute('value', '10')", productQuantity);
        productQuantity.sendKeys(Keys.ENTER);
    }
    public void removeProductsFromCart()
    {
        clickBtn(removeProductFromTheCart);
        waitUntilFinishLoading();
    }
    public void agreeTermsClick()
    {
        clickBtn(agreeTerms);
    }
    public void clickCheckOut()
    {clickBtn(checkOutBtn);}

}
