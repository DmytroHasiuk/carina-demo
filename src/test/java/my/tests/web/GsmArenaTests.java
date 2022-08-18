package my.tests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.*;
import com.qaprosoft.carina.demo.gui.hasiuk.services.LoginService;
import com.qaprosoft.carina.demo.gui.hasiuk.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

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
        String onePlusArticleName = articlePage.getArticleName();
        Assert.assertTrue(StringUtils.equals(firstArticleName, onePlusArticleName), "Articles are not the same");
    }

    @Test(description = "MyTest#Task-001")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyHeaderMenuLinkWorkTest(){
        HomePage homePage = openHomePage();
        homePage.getHeader().clickLinesButton();
        homePage = homePage.getHeader().getHeaderMenu().clickHomeLink();
        NewsPage newsPage = homePage.getHeader().getHeaderMenu().clickNewsLink();
        ReviewsPage reviewsPage = newsPage.getHeader().getHeaderMenu().clickReviewsLink();
        VideosPage videosPage = reviewsPage.getHeader().getHeaderMenu().clickVideosLink();
        FeaturesPage featuresPage = videosPage.getHeader().getHeaderMenu().clickFeaturesPage();
        PhoneFinderPage phoneFinderPage = featuresPage.getHeader().getHeaderMenu().clickPhoneFinderLink();
        DealsPage dealsPage = phoneFinderPage.getHeader().getHeaderMenu().clickDealsLink();
        CoveragePage coveragePage = dealsPage.getHeader().getHeaderMenu().clickCoverageLink();
        ContactPage contactPage = coveragePage.getHeader().getHeaderMenu().clickContactLink();
        MerchPage merchPage = contactPage.getHeader().getHeaderMenu().clickMerchLink();
        contactPage.switchToSecondTab();
        Assert.assertTrue(merchPage.isPageOpened(), "Merch page was not opened");
        contactPage.closeCurrentTab();
        Assert.assertTrue(contactPage.isTabClosed(), "Tab was not closed");
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
