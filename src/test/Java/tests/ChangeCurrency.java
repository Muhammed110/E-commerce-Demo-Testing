package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;

public class ChangeCurrency extends TestBase{
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    SearchPage searchPage;
    String keyWord = "Mac";

    @Test
    public void userCanChangeCurrencySuccessfully()
    {
        homePage = new HomePage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        searchPage = new SearchPage(driver);
        searchPage.selectFromAutoSuggest(keyWord);
        homePage.changeCurrency(1);

        Assert.assertTrue(productDetailsPage.priceValue.getText().contains("€"));
    }
}
