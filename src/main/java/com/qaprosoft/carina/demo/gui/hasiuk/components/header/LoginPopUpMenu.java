package com.qaprosoft.carina.demo.gui.hasiuk.components.header;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.LogInPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPopUpMenu extends AbstractUIObject {

    @FindBy(id = "email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "upass")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "nick-submit")
    private ExtendedWebElement logInButton;

    public LoginPopUpMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public LogInPage loginUser(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        return clickLoginButton();
    }

    private LogInPage clickLoginButton() {
        logInButton.click();
        return new LogInPage(getDriver());
    }

    private void enterEmail(String email) {
        emailInput.type(email);
    }

    private void enterPassword(String pass) {
        passwordInput.type(pass);
    }
}
