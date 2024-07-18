package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "button.button-2.email-a-friend-button")
    WebElement referToFriendBtn;
    @FindBy(id="price-value-4")
    public WebElement priceValue;
    @FindBy(css = "div.product-review-links.add-review")
    WebElement addReviewLink;
    @FindBy(css = "div.product-name")
    public WebElement productName;
    @FindBy(id="add-to-wishlist-button-4")
    WebElement addToWishListBtn;
    @FindBy(css="div.bar-notification.success")
    public WebElement itemAddedToWishListNotification;
    @FindBy(linkText = "wishlist")
    public WebElement WishListBtn;
    @FindBy(id="add-to-cart-button-4")
    WebElement addToCartBtn;
    @FindBy(linkText = "shopping cart")
    WebElement shoppingCartLink;
    @FindBy(id="bar-notification")
    public WebElement addedToCartSuccessfully;
    public void addToCart()
    {
        clickBtn(addToCartBtn);
        waitUntilFinishLoading();
    }
    public void openShoppingCartPage()
    {
        clickBtn(shoppingCartLink);
    }
    public void addToWishList()
    {
        clickBtn(addToWishListBtn);
    }
    public void openWishListPageFromNotificationBar()
    {
        clickBtn(WishListBtn);
    }
    public void openAddReviewPage()
    {
        clickBtn(addReviewLink);
    }
    public void openReferToFriendPage()
    {
        clickBtn(referToFriendBtn);
    }
}
