package com.qaprosoft.carina.demo.mobile.gui.pages.sauceDemo.ios;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.stream.Collectors;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = com.qaprosoft.carina.demo.mobile.gui.pages.sauceDemo.common.ProductPageBase.class)
public class ProductPage extends com.qaprosoft.carina.demo.mobile.gui.pages.sauceDemo.common.ProductPageBase {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @ExtendedFindBy(iosPredicate = "label == 'Products' AND name == 'Products' AND value == 'Products'")
    private ExtendedWebElement productHeader;

    @ExtendedFindBy(accessibilityId = "sort button")
    private ExtendedWebElement sortButton;

    @ExtendedFindBy(iosPredicate = "label == 'Sort by:' AND name == 'Sort by:' AND value == 'Sort by:'")
    private ExtendedWebElement sortHeader;

    @ExtendedFindBy(iosPredicate = "name == 'store item price'")
    private List<ExtendedWebElement> productPrices;

    @ExtendedFindBy(iosPredicate = "label == 'Price - Ascending' AND name == 'Price - Ascending' AND value == 'Price - Ascending'")
    private  ExtendedWebElement priceByAscendingLink;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickSortButton() {
        sortButton.click();
    }

    @Override
    public boolean isSortButtonClicked() {
        return sortHeader.isElementPresent();
    }

    @Override
    public boolean isProductSortedByPrice() {
        List<Double> prices = productPrices.stream()
                .map(price -> price.getAttribute("value"))
                .map(price -> price.replace("$", ""))
                .map(Double::parseDouble)
                .collect(Collectors.toList());
        LOGGER.info("Product prices:" + prices);
        List<Double> sortedPrices = prices.stream().sorted().collect(Collectors.toList());
        LOGGER.info("Sorted product prices:" + sortedPrices);
        return sortedPrices.equals(prices);
    }

    @Override
    public void clickProductByPriceAscendingLink() {
        priceByAscendingLink.click();
    }

    @Override
    public boolean isPageOpened(){
        return productHeader.isPresent();
    }
}
