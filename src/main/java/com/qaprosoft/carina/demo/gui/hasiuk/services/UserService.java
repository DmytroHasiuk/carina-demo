package com.qaprosoft.carina.demo.gui.hasiuk.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.hasiuk.models.User;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.LogInPage;
import org.testng.Assert;

public class UserService implements IDriverPool {

    public User getUser() {
        return new User(R.TESTDATA.get("email"), R.TESTDATA.get("password"));
    }

    public User getUserWithWrongEmail() {
        return new User(R.TESTDATA.get("wrong.email"), R.TESTDATA.get("password"));
    }

    public User getUserWithWrongPassword() {
        return new User(R.TESTDATA.get("email"), R.TESTDATA.get("wrong.password"));
    }

    public HomePage loginValidUser() {
        HomePage homePage = openHomePage();

        homePage.getHeader().getSocialConnectPanel().clickLogInLink();
        homePage.getHeader().getSocialConnectPanel().getLoginPopUpMenu().
                loginUser(getUser().getEmail(), getUser().getPassword());
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
