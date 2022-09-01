package my.tests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.hasiuk.components.news.NewsItem;
import com.qaprosoft.carina.demo.gui.hasiuk.components.phone.page.Comment;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.*;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page.ResultPage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page.SearchPage;
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
    public void verifyGlossaryParagraphHeadersTest() {
        HomePage homePage = openHomePage();
        GlossaryPage glossaryPage = homePage.openGlossaryPageFromFooter();
        Assert.assertTrue(glossaryPage.isParagraphTitleListAndParagraphLinksListEquals(),
                "Sizes of paragraph header and paragraph lists don`t match");
        Assert.assertTrue(glossaryPage.isParagraphTitleMatchLinksFirstLetter(),
                "Glossary titles and lists link first letter don`t match");
    }

    @Test(description = "Learning#Task-008")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyGlossaryParagraphTextByAlphabetTest() {
        HomePage homePage = openHomePage();
        GlossaryPage glossaryPage = homePage.openGlossaryPageFromFooter();
        Assert.assertFalse(glossaryPage.isParagraphTittleEmpty(), "There is no paragraphs headers on the page");
        Assert.assertTrue(glossaryPage.isParagraphTittlesAlphabetic(), "Paragraph titles are not alphabetic");
    }

    @Test(description = "Learning#Task-009", dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/search.xlsx", sheet = "phoneFinder", dsUid = "TUID", dsArgs = "brand,bQuantity")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyPhoneFinderTest(String brand, String quantity) {
        HomePage homePage = openHomePage();
        Assert.assertTrue(homePage.getPhoneFinderBlock().isElementPresent(), "Phone finder block is not present");
        SearchPage searchPage = homePage.getPhoneFinderBlock().clickPhoneFinderButton();
        Assert.assertTrue(searchPage.isBrandPresent(brand), "There is no such brand in list");
        searchPage.searchBrand(brand);
        searchPage.selectBrand(brand);
        SoftAssert softSearchPageAssert = new SoftAssert();
        softSearchPageAssert.assertTrue(searchPage.isBrandSelected(brand), brand + " brand was not selected");
        softSearchPageAssert.assertTrue(searchPage.isBottomShownButtonPresent(),
                "Bottom show button is not presented");
        softSearchPageAssert.assertTrue(searchPage.isBottomShownButtonHasText(quantity),
                "Show button has wrong text");
        softSearchPageAssert.assertAll();
        String searchPageUrl = searchPage.getPageURL();
        ResultPage resultPage = searchPage.clickShownButton();
        SoftAssert softResultPageAssert = new SoftAssert();
        softResultPageAssert.assertTrue(resultPage.isTextWithWrightQuantityPresented(quantity),
                "No needed text is presented");
        softResultPageAssert.assertTrue(resultPage.isTextWithButtonPresented(),
                "Button with text is not presented");
        softResultPageAssert.assertFalse(resultPage.isPhoneListEmpty(), "There in no phones finds");
        softResultPageAssert.assertTrue(resultPage.isAllPhonesHasNeededBrand(brand),
                "There are phone with wrong brand");
        softResultPageAssert.assertTrue(resultPage.isBottomTextPresented(),
                "Text on bottom of the page is wrong");
        softResultPageAssert.assertAll();
        searchPage = resultPage.clickRefineButton();
        Assert.assertEquals(searchPage.getPageURL(), searchPageUrl, "You don`t come back to previous page");
    }

    @Test(description = "Learning#Task-010", dataProvider = "DataProvider")
    @XlsDataSourceParameters(path = "xls/search.xlsx", sheet = "opinions", dsUid = "TUID", dsArgs = "brand")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyOpinionsOnPhonePageTest(String brand) {
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.loginValidUser();
        Assert.assertTrue(homePage.getPhoneFinderBlock().isNeededBrandPresent(brand),
                "There is no such brand: " + brand);
        BrandPhonesPage brandPhonesPage = homePage.getPhoneFinderBlock().clickOnBrand(brand);
        brandPhonesPage.clickPopularityTab();
        Assert.assertFalse(brandPhonesPage.isPhonesEmpty(), "There is no phones on the page");
        PhonePage phonePage = brandPhonesPage.clickOnFirstPhone(brand);
        phonePage.clickOpinionsTab();
        phonePage.sortByBestRating();
        Assert.assertTrue(phonePage.isCommentsSortedByPopularity(), "Comments are not sorted by popularity");
        Comment comment = phonePage.getComment(0);
        int commentVotesBeforeClick = comment.getVotesQuantity();
        comment.clickUvoteButton();
        comment.clickVoteButton();
        phonePage.refresh();
        int commentVotesAfterClick = comment.getVotesQuantity();
        Assert.assertTrue(commentVotesBeforeClick < commentVotesAfterClick,
                "Comment was not rated");
        commentVotesBeforeClick = comment.getVotesQuantity();
        comment.clickUvoteButton();
        comment.clickVoteButton();
        phonePage.refresh();
        commentVotesAfterClick = comment.getVotesQuantity();
        Assert.assertTrue(commentVotesBeforeClick > commentVotesAfterClick,
                "Comment was not unrated");
        phonePage.sortNewestFirst();
        Assert.assertTrue(phonePage.isCommentsSortedByData(), "Comments not sorted by data");
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
