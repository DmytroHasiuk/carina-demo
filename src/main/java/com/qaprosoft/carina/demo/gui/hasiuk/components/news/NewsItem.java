package com.qaprosoft.carina.demo.gui.hasiuk.components.news;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class NewsItem extends AbstractUIObject {

    @FindBy(xpath = ".//h3")
    private ExtendedWebElement title;

    public NewsItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getTitleText() {
        return title.getText();
    }
}
