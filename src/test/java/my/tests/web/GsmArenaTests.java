package my.tests.web;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.LogInPage;
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
        String email = "s9rowa@mail.ru";
        String password = "changeme";
        String nickname = "test.user";

        HomePage homePage = openHomePage();
        LogInPage loginPage = homePage.loginUser(email, password);
        Assert.assertFalse(loginPage.isPageOpened(), "User was not redirected to home page");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homePage.isUserLogin(), "User is not log in");
        softAssert.assertTrue(homePage.isUserNicknameWright(nickname), "User nickname is wrong");
        softAssert.assertAll();
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
