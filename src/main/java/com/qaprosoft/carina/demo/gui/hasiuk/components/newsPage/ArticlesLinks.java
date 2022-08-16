package com.qaprosoft.carina.demo.gui.hasiuk.components.newsPage;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.ArticlePage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ArticlesLinks extends AbstractUIObject {

    @FindBy(xpath = "./div[1]/a")
    private ExtendedWebElement firstArticleLink;

    @FindBy(xpath = "./div[1]/a/h3")
    private ExtendedWebElement firstArticleName;

    public ArticlesLinks(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getFirstArticleName() {
        return firstArticleName.getText();
    }

    public ArticlePage clickFirstArticleLick() {
        firstArticleLink.click();
        return new ArticlePage(getDriver());
    }
}
