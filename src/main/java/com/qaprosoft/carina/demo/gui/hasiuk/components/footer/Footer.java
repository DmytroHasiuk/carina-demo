package com.qaprosoft.carina.demo.gui.hasiuk.components.footer;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Footer extends AbstractUIObject {

    @FindBy(className = "footer-logo")
    private ExtendedWebElement logo;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    public Footer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }
}
