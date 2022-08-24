package com.qaprosoft.carina.demo.gui.hasiuk.components.glossary;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ParagraphsLinks extends AbstractUIObject {

    @FindBy(xpath = "./a")
    private List<ExtendedWebElement> paragraphLinks;

    public ParagraphsLinks(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public List<String> getLinksTexts() {
        List<String> result = new ArrayList<>();
        for (ExtendedWebElement link : paragraphLinks)
            result.add(link.getText());
        return result;
    }
}
