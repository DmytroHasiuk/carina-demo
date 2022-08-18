package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.news.NewsItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class NewsPage extends GsmArenaPage {

    @FindBy(xpath = "//div[@class='news-item'][1]//h3")
    private ExtendedWebElement firstArticleTitle;

    @FindBy(className = "searchFor")
    private ExtendedWebElement inputSearchField;

    @FindBy(xpath = "//input[@class='submit button button-small']")
    private ExtendedWebElement searchButton;

    @FindBy(className = "article-info-name")
    private ExtendedWebElement pageTitle;

    @FindBy(className = "news-item")
    private List<NewsItem> newsItems;

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

    public void searchText(String text) {
        inputSearchField.type(text);
        searchButton.click();
    }

    public String getTitleText() {
        return pageTitle.getText();
    }

    public List<NewsItem> getNewsItems() {
        return newsItems;
    }
}
