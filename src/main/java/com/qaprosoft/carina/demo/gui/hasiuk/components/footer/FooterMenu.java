package com.qaprosoft.carina.demo.gui.hasiuk.components.footer;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.GlossaryPage;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.NewsPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class FooterMenu extends AbstractUIObject {

    @FindBy(xpath = "./p/a[1]")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = "./p/a[8]")
    private ExtendedWebElement glossaryLink;

    public FooterMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public NewsPage clickNewsOption() {
        newsLink.click();
        return new NewsPage(getDriver());
    }

    public GlossaryPage clickGlossaryOption() {
        glossaryLink.click();
        return new GlossaryPage(getDriver());
    }
}
