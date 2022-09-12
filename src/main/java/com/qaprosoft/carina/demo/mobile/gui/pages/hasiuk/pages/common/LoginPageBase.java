package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {
    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void clickMaleButton();

    public abstract void clickFemaleButton();

    public abstract void clickPrivacyPolicyCheckbox();

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isInputNameFieldPresent();

    public abstract boolean isInputPasswordFieldPresent();

    public abstract boolean isMaleButtonPresent();

    public abstract boolean isFemaleButtonPresent();

    public abstract boolean isPrivacyPolicyCheckboxPresent();

    public abstract boolean isPrivacyPolicyCheckboxChecked();

    public abstract boolean isNameTyped(String name);

    public abstract boolean isPasswordTyped(String password);

    public abstract boolean isMaleRadioButtonChecked();

    public abstract boolean isFemaleRadioButtonChecked();
}
