package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.demo.gui.hasiuk.components.newsPage.ArticlesLinks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.lang.model.element.Element;

public class NewsPage extends GsmArenaPage {

    @FindBy(className = "floating-title")
    private ArticlesLinks articlesLinks;

    public NewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3");
    }

    public ArticlesLinks getArticlesLinks() {
        return articlesLinks;
    }

    public String getFirstArticleName() {
        return getArticlesLinks().getFirstArticleName();
    }

    public ArticlePage openFirstArticlePage() {
        ArticlePage articlePage = getArticlesLinks().clickFirstArticleLick();
        Assert.assertTrue(articlePage.isPageOpened(), "First article page was not opened");
        return articlePage;
    }
}
