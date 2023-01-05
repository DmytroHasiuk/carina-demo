package my.tests.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.sauceDemo.common.ProductPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoIosTest implements IAbstractTest {

//    messing with commit
    @Test(description = "Learning-mobile-iOS#Task 001")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void clickSortButtonTest(){
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        Assert.assertTrue(productPage.isPageOpened(), "Page was not opened");
        productPage.clickSortButton();
        Assert.assertTrue(productPage.isSortButtonClicked(), "Sort button wasn`t clicked");
    }

    @Test(description = "Learning-mobile-iOS#Task 002")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void isPricesSortedByPricesTest(){
        ProductPageBase productPage = initPage(getDriver(), ProductPageBase.class);
        Assert.assertTrue(productPage.isPageOpened(), "Page was not opened");
        productPage.clickSortButton();
        Assert.assertTrue(productPage.isSortButtonClicked(), "Sort button wasn`t clicked");
        productPage.clickProductByPriceAscendingLink();
        Assert.assertTrue(productPage.isProductSortedByPrice(), "Product is sorted by price");
    }
}
