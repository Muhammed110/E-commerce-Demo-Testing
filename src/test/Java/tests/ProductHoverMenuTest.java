package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class ProductHoverMenuTest extends TestBase{
    HomePage homePage;
    @Test
    public void userCanSelectElementsFromHoverMenu()
    {
        homePage = new HomePage(driver);
        homePage.selectCellPhones();
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/cell-phones");
    }
}
