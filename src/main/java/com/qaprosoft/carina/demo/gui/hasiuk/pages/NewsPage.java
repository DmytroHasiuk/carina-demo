package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewsPage extends GsmArenaPage {

    @FindBy(xpath = "//div[@class='news-item'][1]//h3")
    private ExtendedWebElement firstArticleTitle;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }

    public String getFirstArticleName() {
        return firstArticleTitle.getText();
    }

    public ArticlePage openFirstArticlePage() {
        firstArticleTitle.click();
        ArticlePage articlePage = new ArticlePage(getDriver());
        Assert.assertTrue(articlePage.isPageOpened(), "First article page was not opened");
        return articlePage;
    }
}
