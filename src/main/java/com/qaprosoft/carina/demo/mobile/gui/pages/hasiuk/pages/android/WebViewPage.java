package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.MapPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.WebViewPageBase;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WebViewPageBase.class)
public class WebViewPage extends WebViewPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*id/content_frame\")")
    private ExtendedWebElement webViewContent;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"Navigate up\")")
    private ExtendedWebElement leftBurgerMenuButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*design_navigation_view\")" +
            ".childSelector(new UiSelector().index(3))")
    private ExtendedWebElement mapLink;

    public WebViewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickLeftBurgerMenuButton() {
        leftBurgerMenuButton.click();
    }

    @Override
    public MapPageBase clickMapLink() {
        mapLink.click();
        return initPage(getDriver(), MapPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return webViewContent.isPresent();
    }
}
