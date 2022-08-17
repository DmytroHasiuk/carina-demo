package com.qaprosoft.carina.demo.gui.hasiuk.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.hasiuk.models.User;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.LogInPage;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginService implements IDriverPool {

    public HomePage loginValidUser() {
        HomePage homePage = openHomePage();
        UserService userService = new UserService();
        User validUser = userService.getUser();
        homePage.getHeader().getSocialConnectPanel().clickLogInLink();
        homePage.getHeader().getSocialConnectPanel().getLoginPopUpMenu().
                loginUser(validUser.getEmail(), validUser.getPassword());
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue(homePage.isUserNicknameWright(R.TESTDATA.get("nickname")), "User did not log in");
        return homePage;
    }

    public LogInPage loginInvalidUser(User user) {
        HomePage homePage = openHomePage();

        homePage.getHeader().getSocialConnectPanel().clickLogInLink();
        LogInPage logInPage = homePage.getHeader().getSocialConnectPanel().getLoginPopUpMenu().
                loginUser(user.getEmail(), user.getPassword());
        Assert.assertTrue(logInPage.isPageOpened(), "Log in page was not opened");
        return logInPage;
    }

    private HomePage openHomePage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }
}
