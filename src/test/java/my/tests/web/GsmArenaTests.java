package my.tests.web;

import com.google.common.collect.Ordering;
import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.hasiuk.components.news.NewsItem;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.*;
import com.qaprosoft.carina.demo.gui.hasiuk.services.LoginService;
import com.qaprosoft.carina.demo.gui.hasiuk.services.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GsmArenaTests implements IAbstractTest {

    @Test(description = "Learning#Task-001")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void isHeaderElementPresentTest() {
        HomePage homePage = openHomePage();
        Assert.assertTrue(homePage.getHeader().isAllElementsPresent(), "Not all element is presented");
    }

    @Test(description = "Learning#Task-002")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifySuccessLogInTest() {
        LoginService loginService = new LoginService();
        loginService.loginValidUser();
    }

    @Test(description = "Learning#Task-003")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyLoginWithWrongEmailTest() {
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        LogInPage logInPage = loginService.loginInvalidUser(userService.getUserWithWrongEmail());
        Assert.assertTrue(logInPage.isWrongEmailAlertPresent(), "Wrong error message");
    }

    @Test(description = "Learning#Task-004")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyLoginWithWrongPasswordTest() {
        LoginService loginService = new LoginService();
        UserService userService = new UserService();
        LogInPage logInPage = loginService.loginInvalidUser(userService.getUserWithWrongPassword());
        Assert.assertTrue(logInPage.isWrongPasswordAlertPresent(), "Wrong error message");
    }

    @Test(description = "Learning#Task-005")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyArticleNameTest() {
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.loginValidUser();
        NewsPage newsPage = homePage.openNewsPageFromFooter();
        String firstArticleName = newsPage.getFirstArticleName();
        ArticlePage articlePage = newsPage.openFirstArticlePage();
        Assert.assertTrue(StringUtils.equals(firstArticleName, articlePage.getArticleName()),
                "Articles are not the same");
    }

    @Test(description = "Learning#Task-006", dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/search.xlsx", sheet = "newsGSM", dsUid = "TUID", dsArgs = "Input")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifySearchingProcessTest(String input) {
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.loginValidUser();
        NewsPage newsPage = homePage.openNewsPageFromFooter();
        newsPage.searchText(input);
        String expectedNewsPageTitle = "Results for \"" + input + "\"";
        Assert.assertTrue(StringUtils.equals(expectedNewsPageTitle, newsPage.getTitleText()),
                "Titles does`nt match");
        List<NewsItem> newsItems = newsPage.getNewsItems();
        Assert.assertFalse(CollectionUtils.isEmpty(newsItems), "News was not found");
        SoftAssert softAssert = new SoftAssert();
        for (NewsItem item : newsItems)
            softAssert.assertTrue(StringUtils.contains(item.getTitleText(), input),
                    "Phrase not found - \"" + input + "\"");
        softAssert.assertAll();
    }

    @Test(description = "Learning#Task-007")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyGlossaryParagraphHeadersTest(){
        HomePage homePage = openHomePage();
        GlossaryPage glossaryPage = homePage.openGlossaryPageFromFooter();
        Assert.assertTrue(glossaryPage.isParagraphTitleListAndParagraphLinksListEquals(),
                "Sizes of paragraph header and paragraph lists don`t match");
        Assert.assertTrue(glossaryPage.isParagraphTitleMatchLinksFirstLetter(),
                "Glossary titles and lists link first letter don`t match");
    }

    @Test(description = "Learning#Task-008")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void isCollectionSorted(){
        HomePage homePage = openHomePage();
        GlossaryPage glossaryPage = homePage.openGlossaryPageFromFooter();
        Assert.assertFalse(glossaryPage.isParagraphTittleEmpty(), "There is no paragraphs headers on the page");
        Assert.assertTrue(glossaryPage.isParagraphTittlesAlphabetic(), "Paragraph titles are not alphabetic");
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
