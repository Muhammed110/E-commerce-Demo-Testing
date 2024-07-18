package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReferToFriendPage extends PageBase {
    public ReferToFriendPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id="FriendEmail")
    WebElement friendEmail;
    @FindBy(id="YourEmailAddress")
    public WebElement yourEmail;
    @FindBy(id="PersonalMessage")
    WebElement msgToYourFriend;
    @FindBy(css="button.button-1.send-email-a-friend-button")
    WebElement sendMessageBtn;
    @FindBy(css="div.result")
    public WebElement emailSentSuccessfullyMessage;
    public void referToYourFriend(String frEmail,String messageToYourFriend)
    {
        typeText(friendEmail, frEmail);
        typeText(msgToYourFriend,messageToYourFriend);
        clickBtn(sendMessageBtn);
    }
}
