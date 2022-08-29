package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class BrandPhonesPage extends GsmArenaPage {

    @FindBy(xpath = "//h1")
    private ExtendedWebElement articleName;

    @FindBy(xpath = "//li[@class='article-info-meta-link help help-sort-popularity']")
    private ExtendedWebElement popularityTab;

    @FindBy(xpath = "//div[@class='makers']//li")
    private List<ExtendedWebElement> phones;

    public BrandPhonesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(String brand) {
        return (articleName.isPresent() && StringUtils.equalsIgnoreCase(articleName.getText(), brand + " phones"));
    }

    public void clickPopularityTab() {
        popularityTab.click();
    }

    public PhonePage clickOnFirstPhone(String brand) {
        PhonePage phonePage = new PhonePage(getDriver());
        String nameOfPhone = brand + " " + nameOfFirstPhone();
        phones.get(0).click();
        Assert.assertTrue(phonePage.isPageOpened(nameOfPhone), nameOfPhone + " was not opened");
        return phonePage;
    }

    public boolean isPhonesEmpty() {
        return CollectionUtils.isEmpty(phones);
    }

    private String nameOfFirstPhone() {
        return phones.get(0).getText();
    }
}
