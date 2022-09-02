package com.qaprosoft.carina.demo.gui.hasiuk.components.common.phone.finder;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.BrandPhonesPage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page.SearchPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class PhoneFinderBlock extends AbstractUIObject {

    @FindBy(xpath = ".//a[@class='pad-single pad-finder']")
    private ExtendedWebElement phoneFinderButton;

    @FindBy(xpath = ".//li/a")
    private List<ExtendedWebElement> brandList;

    @FindBy(xpath = ".//a[@class='pad-multiple pad-allbrands']")
    private ExtendedWebElement allBrandsButton;

    @FindBy(xpath = ".//a[@class='pad-multiple pad-rumormill']")
    private ExtendedWebElement rumorMillButton;

    public PhoneFinderBlock(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isElementPresent() {
        return (phoneFinderButton.isPresent() && (!brandList.isEmpty()) &&
                allBrandsButton.isPresent() && rumorMillButton.isPresent());
    }

    public SearchPage clickPhoneFinderButton() {
        SearchPage searchPage = new SearchPage(getDriver());
        phoneFinderButton.click();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page was not opened");
        return searchPage;
    }

    public boolean isNeededBrandPresent(String brand) {
        return getBrandNameList().contains(brand.toLowerCase());
    }

    public BrandPhonesPage clickOnBrand(String brand) {
        BrandPhonesPage brandPhonesPage = new BrandPhonesPage(getDriver());
        brandList.get(getBrandNameList().indexOf(brand.toLowerCase())).click();
        Assert.assertTrue(brandPhonesPage.isPageOpened(brand));
        return brandPhonesPage;
    }

    private List<String> getBrandNameList() {
        return brandList.stream().map(ExtendedWebElement::getText).map(String::toLowerCase).collect(Collectors.toList());
    }
}
