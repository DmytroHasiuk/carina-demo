package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends GsmArenaPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isUserNicknameWright(String nickname) {
        getHeader().clickLinesButton();
        return getHeader().getSocialConnectPanel().isUserNicknameWright(nickname);
    }

    public NewsPage openNewsPageFromFooter() {
        scrollUntilPageEnd();
        NewsPage newsPage = getFooter().getFooterMenu().clickNewsOption();
        Assert.assertTrue(newsPage.isPageOpened(), "News page was not opened");
        return newsPage;
    }

    private void scrollUntilPageEnd() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        long documentHeightBeforeScroll = (Long) js.executeScript("return document.body.scrollHeight");
        while (true) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            long documentHeightAfterScroll = (Long) js.executeScript("return document.body.scrollHeight");
            if (documentHeightBeforeScroll == documentHeightAfterScroll) break;
            documentHeightBeforeScroll = documentHeightAfterScroll;
        }
    }
}
