package com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.phoneFinder.ShowButton;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.GsmArenaPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchPage extends GsmArenaPage {
    private final String articleTitleText = "Phone finder";

    @FindBy(xpath = "//h1[@class='article-info-name']")
    private ExtendedWebElement articleTitle;

    @FindBy(xpath = "//button[@data-id='sMakers']")
    private ExtendedWebElement brandButton;

    @FindBy(xpath = "//div[@class='l-col l-col-1-2 mr10'][1]//input")
    private ExtendedWebElement inputBrandForm;

    @FindBy(xpath = "//div[@class='row']//div[@class='row']//div[@class='row'][1]//li")
    private List<ExtendedWebElement> brandCheckBoxes;

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

    public boolean isBrandPresent(String brand) {
        List<String> existingBrands = readTextOfBrandCheckBoxes();
        return existingBrands.contains(brand.toLowerCase());
    }

    public void selectBrand(String brand) {
        List<String> existingBrands = readTextOfBrandCheckBoxes();
        brandCheckBoxes.get(existingBrands.indexOf(brand.toLowerCase())).click();
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

    public boolean isBrandSelected(String brand) {
        List<String> existingBrands = readTextOfBrandCheckBoxes();
        return StringUtils.containsIgnoreCase(brandCheckBoxes.get(existingBrands.indexOf(brand.toLowerCase()))
                .getAttribute("class"), "selected");
    }

    private List<String> readTextOfBrandCheckBoxes() {
        return brandCheckBoxes.stream().map(e -> e.getAttribute("textContent"))
                .map(String::toLowerCase)
                .collect(Collectors.toList());
    }
}
