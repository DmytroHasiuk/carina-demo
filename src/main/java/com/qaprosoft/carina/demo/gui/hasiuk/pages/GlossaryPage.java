package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.glossary.ParagraphsLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GlossaryPage extends GsmArenaPage {

    @FindBy(xpath = "//div[@class='st-text']/h3")
    private List<ExtendedWebElement> paragraphTitles;

    @FindBy(xpath = "//div[@class='st-text']/p")
    private List<ParagraphsLinks> paragraphs;

    public GlossaryPage(WebDriver driver) {
        super(driver);
        setPageURL("/glossary.php3");
    }

    public boolean isParagraphTitleListAndParagraphLinksListEquals() {
        return paragraphs.size() == paragraphTitles.size();
    }

    public boolean isParagraphTitleMatchLinksFirstLetter() {
        for (int i = 0; i < paragraphs.size(); i++) {
            List<String> paragraphLinksText = paragraphs.get(i).getLinksTexts();
            if (i == 0) {
                for (String linkText : paragraphLinksText)
                    if (!Character.isDigit(linkText.charAt(0))) return false;
            } else {
                for (String linkText : paragraphLinksText)
                    if (!(Character.toLowerCase(linkText.charAt(0)) ==
                            Character.toLowerCase(paragraphTitles.get(i).getText().charAt(0)))) return false;
            }
        }
        return true;
    }
}
