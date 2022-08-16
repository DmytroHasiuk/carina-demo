package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends GsmArenaPage {
    private final String wrongEmail = "Reason: User record not found.";
    private final String wrongPassword = "Reason: Wrong password.";

    @FindBy(xpath = "//*[@class='normal-text res-error']/p")
    private ExtendedWebElement errorTextParagraph;

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageURL("/login.php3");
    }

    public boolean isWrongEmailAlertPresent() {
        return StringUtils.equalsIgnoreCase(errorTextParagraph.getText(), wrongEmail);
    }

    public boolean isWrongPasswordAlertPresent() {
        return StringUtils.equalsIgnoreCase(errorTextParagraph.getText(), wrongPassword);
    }
}
