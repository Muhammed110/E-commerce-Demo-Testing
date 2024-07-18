package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchUsingAutoSuggest extends TestBase{
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    String keyWord = "Mac";


    @Test
    public void userCanSearchForProductUsingAutoSuggestionSuccessfully()
    {
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.selectFromAutoSuggest(keyWord);
        Assert.assertEquals("Apple MacBook Pro 13-inch", productDetailsPage.productName.getText());

    }
}
