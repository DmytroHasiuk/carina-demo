package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;
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
        NewsPage newsPage = getFooterMenu().clickNewsOption();
        Assert.assertTrue(newsPage.isPageOpened(), "News page was not opened");
        return newsPage;
    }

    public GlossaryPage openGlossaryPageFromFooter() {
        GlossaryPage glossaryPage = getFooterMenu().clickGlossaryOption();
        Assert.assertTrue(glossaryPage.isPageOpened(), "Glossary page was not opened");
        return glossaryPage;
    }
}
