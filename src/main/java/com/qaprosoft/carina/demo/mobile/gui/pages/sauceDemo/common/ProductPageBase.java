package com.qaprosoft.carina.demo.mobile.gui.pages.sauceDemo.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickSortButton();

    public abstract boolean isSortButtonClicked();

    public abstract boolean isProductSortedByPrice();

    public abstract void clickProductByPriceAscendingLink();
}
