package my.tests.mobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.crypto.CryptoTool;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.CarinaDescriptionPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.CarinaDescriptionPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.common.WelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.LoginPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.WebViewPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HasiukMobileTests implements IAbstractTest {

    @Test(description = "Learning-mobile#Task 001")
    @MethodOwner(owner = "Dmytro Hasiuk")
    public void verifyLoginPage() {
        HomePageBase homePageBase = openHomePage();
        LoginPageBase loginPageBase = homePageBase.clickNextButton();
        Assert.assertTrue(loginPageBase.isPageOpened(), "Login page was not opened");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(loginPageBase.isInputNameFieldPresent(), "Input name field is not present");
        softAssert.assertTrue(loginPageBase.isInputPasswordFieldPresent(), "Input password field is not present");
        softAssert.assertTrue(loginPageBase.isMaleButtonPresent(), "Male radio button is not present");
        softAssert.assertTrue(loginPageBase.isFemaleButtonPresent(), "Female radio button is not present");
        softAssert.assertTrue(loginPageBase.isPrivacyPolicyCheckboxPresent(),
                "Privacy policy checkbox is not present");
        softAssert.assertFalse(loginPageBase.isPrivacyPolicyCheckboxChecked(),
                "Privacy policy checkbox is checked");
        softAssert.assertAll();
        loginPageBase.typeName(R.TESTDATA.get("name"));
        Assert.assertTrue(loginPageBase.isNameTyped(R.TESTDATA.get("name")), "Name was not type");
        loginPageBase.typePassword(R.TESTDATA.get("mobile.password"));
        Assert.assertTrue(loginPageBase.isPasswordTyped(R.TESTDATA.get("mobile.password")), "Password was not typed");
        loginPageBase.clickFemaleButton();
        Assert.assertTrue(loginPageBase.isFemaleRadioButtonChecked(), "Female button was not clicked");
        loginPageBase.clickMaleButton();
        Assert.assertTrue(loginPageBase.isMaleRadioButtonChecked(), "Male button was not clicked");
        loginPageBase.clickPrivacyPolicyCheckbox();
        Assert.assertTrue(loginPageBase.isPrivacyPolicyCheckboxChecked(), "Privacy policy checkbox is not checked");
        WebViewPageBase webViewPageBase = loginPageBase.clickSignUpButton();
        Assert.assertTrue(webViewPageBase.isPageOpened(), "Web view page is not opened");
    }

    private HomePageBase openHomePage() {
        HomePageBase homePageBase = initPage(getDriver(), HomePageBase.class);
        Assert.assertTrue(homePageBase.isPageOpened(), "Home page was not opened");
        return homePageBase;
    }
}
