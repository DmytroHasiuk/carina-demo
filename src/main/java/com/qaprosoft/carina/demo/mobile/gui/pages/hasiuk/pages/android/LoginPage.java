package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.android;

import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.WebViewPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase implements IMobileUtils {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/action_bar_root\")")
    private ExtendedWebElement barTool;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/name\")")
    private ExtendedWebElement inputNameField;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/password\")")
    private ExtendedWebElement inputPasswordField;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/radio_male\")")
    private ExtendedWebElement maleRadioButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/radio_female\")")
    private ExtendedWebElement femaleRadioButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/checkbox\")")
    private ExtendedWebElement privacyPolicyCheckBox;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/login_button\")")
    private ExtendedWebElement singUpButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return barTool.isElementPresent();
    }

    @Override
    public boolean isInputNameFieldPresent() {
        return inputNameField.isPresent();
    }

    @Override
    public boolean isInputPasswordFieldPresent() {
        return inputPasswordField.isPresent();
    }

    @Override
    public boolean isMaleButtonPresent() {
        return maleRadioButton.isPresent();
    }

    @Override
    public boolean isFemaleButtonPresent() {
        return femaleRadioButton.isPresent();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxPresent() {
        return privacyPolicyCheckBox.isPresent();
    }

    @Override
    public boolean isPrivacyPolicyCheckboxChecked() {
        return Boolean.parseBoolean(privacyPolicyCheckBox.getAttribute("checked"));
    }

    @Override
    public void typeName(String name) {
        inputNameField.type(name);
    }

    @Override
    public void typePassword(String password) {
        inputPasswordField.type(password);
    }

    @Override
    public void clickMaleButton() {
        maleRadioButton.click();
    }

    @Override
    public void clickFemaleButton() {
        femaleRadioButton.click();
    }

    @Override
    public void clickPrivacyPolicyCheckbox() {
        privacyPolicyCheckBox.click();
    }

    @Override
    public WebViewPageBase clickSignUpButton() {
        singUpButton.click();
        return initPage(getDriver(), WebViewPageBase.class);
    }

    @Override
    public boolean isNameTyped(String name) {
        return StringUtils.equalsIgnoreCase(inputNameField.getText(), name);
    }

    @Override
    public boolean isPasswordTyped(String password) {
        CryptoTool cryptoTool = new CryptoTool();
        String decryptKey = StringUtils.remove(password, "{crypt:");
        decryptKey = StringUtils.remove(decryptKey, "}");
        return StringUtils.equalsIgnoreCase(inputPasswordField.getText(), cryptoTool.decrypt(decryptKey));
    }

    @Override
    public boolean isMaleRadioButtonChecked() {
        return Boolean.parseBoolean(maleRadioButton.getAttribute("checked"));
    }

    @Override
    public boolean isFemaleRadioButtonChecked() {
        return Boolean.parseBoolean(femaleRadioButton.getAttribute("checked"));
    }

    @Override
    public boolean isSignUpButtonActive() {
        return Boolean.parseBoolean(singUpButton.getAttribute("enabled"));
    }

    @Override
    public WebViewPageBase login() {
        typeName(R.TESTDATA.get("name"));
        typePassword(R.TESTDATA.get("mobile.password"));
        clickMaleButton();
        clickPrivacyPolicyCheckbox();
        return clickSignUpButton();
    }
}
