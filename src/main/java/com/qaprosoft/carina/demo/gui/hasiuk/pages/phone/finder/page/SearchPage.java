package com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.phoneFinder.ShowButton;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.GsmArenaPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends GsmArenaPage {
    private final String articleTitleText = "Phone finder";

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement articleTitle;

    @FindBy(xpath = "//button[@data-id='sMakers']")
    private ExtendedWebElement brandButton;

    @FindBy(xpath = "//div[@class='l-col l-col-1-2 mr10'][1]//input")
    private ExtendedWebElement inputBrandForm;

    @FindBy(xpath = "//li[@data-original-index='115']")
    private ExtendedWebElement xiaomiBrandCheckBox;

    @FindBy(xpath = "//span[@class='pf-border']")
    private ShowButton bottomShowButton;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return (articleTitle.isPresent() && articleTitle.getText().equals(articleTitleText));
    }

    public void searchBrand(String brand) {
        brandButton.click();
        inputBrandForm.type(brand);
    }

    public void selectXiaomiBrand() {
        xiaomiBrandCheckBox.click();
    }

    public boolean isBottomShownButtonPresent() {
        return bottomShowButton.isPresent();
    }

    public boolean isBottomShownButtonHasText(String brandQuantity) {
        String textToCheck = brandQuantity + " results";
        return StringUtils.equalsIgnoreCase(textToCheck, bottomShowButton.getButtonText());
    }

    public ResultPage clickShownButton() {
        return bottomShowButton.click();
    }

    public boolean isXiaomiBrandSelected() {
        return StringUtils.equalsIgnoreCase(xiaomiBrandCheckBox.getAttribute("class"), "active selected");
    }
}
