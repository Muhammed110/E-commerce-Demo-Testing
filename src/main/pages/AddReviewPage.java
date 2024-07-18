package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddReviewPage extends PageBase {
    public AddReviewPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "AddProductReview_Title")
    WebElement reviewTitle;
    @FindBy(id = "AddProductReview_ReviewText")
    WebElement reviewText;
    @FindBy(id = "addproductrating_1")
    WebElement rate1RdBtn;
    @FindBy(id = "addproductrating_2")
    WebElement rate2RdBtn;
    @FindBy(id = "addproductrating_3")
    WebElement rate3RdBtn;
    @FindBy(id = "addproductrating_4")
    WebElement rate4RdBtn;
    @FindBy(id = "addproductrating_5")
    WebElement rate5RdBtn;
    @FindBy(id = "add-review")
    WebElement submitReviewBtn;
    @FindBy(css="div.bar-notification.success")
    public WebElement reviewAddedSuccessfully;

    public void enterReviewData(String title, String text, int rate)
    {
        typeText(reviewTitle,title);
        typeText(reviewText,text);
        if (rate == 1)
            clickBtn(rate1RdBtn);
        else if (rate == 2)
            clickBtn(rate2RdBtn);
        else if (rate == 3)
            clickBtn(rate3RdBtn);
        else if (rate == 4)
            clickBtn(rate4RdBtn);
        else if (rate == 5)
            clickBtn(rate5RdBtn);
        clickBtn(submitReviewBtn);
    }
}
