package com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.GsmArenaPage;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class ResultPage extends GsmArenaPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String BtnText = "To refine your search click here.";
    private final String textInBottom = "Note: Please report wrong Phone Finder results here.";
    private final String articleTitleText = "Phone finder results";

    @FindBy(className = "article-info-name")
    private ExtendedWebElement articleTitle;

    @FindBy(xpath = "//div[@class='st-text'][1]/p")
    private ExtendedWebElement paragraphUnderTittle;

    @FindBy(xpath = "//div[@class='st-text'][1]//a")
    private ExtendedWebElement refineButton;

    @FindBy(xpath = "//div[@class='makers']//span")
    private List<ExtendedWebElement> resultPhones;

    @FindBy(xpath = "//div[@class='st-text'][2]/p")
    private ExtendedWebElement paragraphUnderPhones;

    public ResultPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return (articleTitle.isPresent() && articleTitle.getText().equals(articleTitleText));
    }

    public boolean isTextInParagraphPresented(String textToCheck) {
        return StringUtils.containsIgnoreCase(paragraphUnderTittle.getText(), textToCheck);
    }

    public boolean isTextWithButtonPresented() {
        return (refineButton.isPresent() && isTextInParagraphPresented(BtnText));
    }

    public boolean isPhoneListEmpty() {
        return CollectionUtils.isEmpty(resultPhones);
    }

    public boolean isAllPhonesHasNeededBrand(String neededBrand) {
        for (ExtendedWebElement phone : resultPhones) {
            if (!StringUtils.containsIgnoreCase(phone.getText(), neededBrand)) {
                LOGGER.info(phone.getText() + " is not " + neededBrand);
                return false;
            }
        }
        return true;
    }

    public boolean isBottomTextPresented() {
        return StringUtils.equalsIgnoreCase(paragraphUnderPhones.getText(), textInBottom);
    }

    public SearchPage clickRefineButton() {
        SearchPage searchPage = new SearchPage(getDriver());
        refineButton.click();
        Assert.assertTrue(searchPage.isPageOpened(), "Search page was not opened");
        return searchPage;
    }
}
