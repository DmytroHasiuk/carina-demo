package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.HomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.LoginPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/carina_logo\")")
    private ExtendedWebElement carinaLogo;
    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/next_button\")")
    private ExtendedWebElement nextButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return carinaLogo.isElementPresent();
    }

    @Override
    public LoginPageBase clickNextButton() {
        tap(nextButton);
        return initPage(getDriver(), LoginPageBase.class);
    }
}
