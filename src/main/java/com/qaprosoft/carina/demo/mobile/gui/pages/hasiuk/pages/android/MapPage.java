package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common.MapPageBase;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MapPageBase.class)
public class MapPage extends MapPageBase {

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().resourceIdMatches(\".*toolbar\")" +
            ".childSelector(new UiSelector().index(1))")
    private ExtendedWebElement pageHeader;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"Zoom in\")")
    private ExtendedWebElement zoomInButton;

    @ExtendedFindBy(androidUIAutomator = "new UiSelector().description(\"Zoom out\")")
    private ExtendedWebElement zoomOutButton;

    public MapPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isZoomInBtnPresent() {
        return zoomInButton.isPresent();
    }

    @Override
    public boolean isZoomOutsBtnPresent() {
        return zoomOutButton.isPresent();
    }

    @Override
    public boolean isZoomInAboveZoomOut() {
        int yCoordZoomIn = zoomInButton.getLocation().getY();
        int yCoordZoomOut = zoomOutButton.getLocation().getY();
        return (yCoordZoomOut > yCoordZoomIn);
    }

    @Override
    public boolean isPageOpened() {
        return StringUtils.equalsIgnoreCase(pageHeader.getText(), "map");
    }
}
