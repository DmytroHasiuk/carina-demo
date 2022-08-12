package com.qaprosoft.carina.demo.gui.hasiuk.services;

import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.gui.hasiuk.models.User;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.HomePage;
import org.testng.Assert;

public class UserService implements IDriverPool {

    public User getUser() {
        return new User(R.TESTDATA.get("email"), R.TESTDATA.get("password"));
    }

    public HomePage loginUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");

        homePage.getHeader().getSocialConnectPanel().clickLogInLink();
        homePage.getHeader().getSocialConnectPanel().getLoginPopUpMenu().
                loginUser(getUser().getEmail(), getUser().getPassword());
        return homePage;
    }
}
