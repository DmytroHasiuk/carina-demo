package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends GsmArenaPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNicknameWright(String nickname) {
        getHeader().clickLinesButton();
        return getHeader().getSocialConnectPanel().isUserNicknameWright(nickname);
    }

    public NewsPage openNewsPageFromFooter() {
        NewsPage newsPage = getFooter().getFooterMenu().clickNewsOption();
        Assert.assertTrue(newsPage.isPageOpened(), "News page was not opened");
        return newsPage;
    }
}
