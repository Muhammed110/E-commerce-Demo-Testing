package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchPage;

public class SearchTest extends TestBase{
    SearchPage searchPage;
    String searchWord = "Apple MacBook Pro 13-inch";

    @Test
    public void userCanSearchForProductSuccessfully()
    {
        searchPage = new SearchPage(driver);
        searchPage.enterSearchWord(searchWord);
        searchPage.clickSearch();
        searchPage.clickOnProductInSearchResult();
        Assert.assertEquals(searchWord, searchPage.productName.getText());
    }

}
