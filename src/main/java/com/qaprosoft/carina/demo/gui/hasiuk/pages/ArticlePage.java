package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlePage extends GsmArenaPage {

    @FindBy(className = "article-info-name")
    private ExtendedWebElement articleName;

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public String getArticleName() {
        return articleName.getText();
    }

    @Override
    public boolean isPageOpened() {
        return articleName.isElementPresent();
    }
}
