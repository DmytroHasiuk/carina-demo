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
}
