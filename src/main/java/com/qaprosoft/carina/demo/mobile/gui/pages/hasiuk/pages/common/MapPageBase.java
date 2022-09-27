package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage {

    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isZoomInBtnPresent();

    public abstract boolean isZoomOutsBtnPresent();

    public abstract boolean isZoomInAboveZoomOut();
}
