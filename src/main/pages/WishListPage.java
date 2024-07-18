package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishListPage extends PageBase {
    public WishListPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button.remove-btn")
    WebElement removeFromCart;
    @FindBy(id="UpdateWishList")
    WebElement updateWishList;
    @FindBy(css="div.no-data")
    public WebElement wishListEmptyNotifications;
    public void removeFromCart()
    {
        clickBtn(removeFromCart);
    }
}
