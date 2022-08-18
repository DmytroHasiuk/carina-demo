package my.tests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.dataprovider.annotations.XlsDataSourceParameters;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.hasiuk.components.news.NewsItem;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.LogInPage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.NewsPage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.ArticlePage;
import com.qaprosoft.carina.demo.gui.hasiuk.services.LoginService;
import com.qaprosoft.carina.demo.gui.hasiuk.services.UserService;
import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
    public void verifySearchingProcessTest(String input){
        LoginService loginService = new LoginService();
        HomePage homePage = loginService.loginValidUser();
        NewsPage newsPage = homePage.openNewsPageFromFooter();
        newsPage.searchText(R.TESTDATA.get("input.text"));
        String expectedNewsPageTitle = "Results for \"" + input + "\"";
        Assert.assertTrue(StringUtils.equals(expectedNewsPageTitle, newsPage.getTitleText()),
                "Titles does`nt match");
        SoftAssert softAssert = new SoftAssert();
        for (NewsItem item : newsPage.getNewsItems())
            softAssert.assertTrue(StringUtils.contains(item.getTitleText(), input));
        softAssert.assertAll();
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
