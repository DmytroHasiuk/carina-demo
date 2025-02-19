package com.qaprosoft.carina.demo.mobile.gui.pages.hasiuk.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickLeftBurgerMenuButton();

    public abstract MapPageBase clickMapLink();
}
