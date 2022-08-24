package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.glossary.ParagraphsLinks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class GlossaryPage extends GsmArenaPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

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
                    if (!Character.isDigit(linkText.charAt(0))) {
                        LOGGER.error("Paragraph link : \"" + linkText + "\" does not match first letter of paragraph " +
                                "header: \"" + paragraphTitles.get(i).getText() + "\"");
                        return false;
                    } else LOGGER.info("Paragraph link : \"" + linkText + "\" matches first letter of paragraph " +
                            "header: \"" + paragraphTitles.get(i).getText() + "\"");
            } else {
                for (String linkText : paragraphLinksText)
                    if (!(Character.toLowerCase(linkText.charAt(0)) ==
                            Character.toLowerCase(paragraphTitles.get(i).getText().charAt(0)))) {
                        LOGGER.error("Paragraph link : \"" + linkText + "\" does not match first letter of paragraph " +
                                "header: \"" + paragraphTitles.get(i).getText() + "\"");
                        return false;
                    } else LOGGER.info("Paragraph link : \"" + linkText + "\" matches first letter of paragraph " +
                            "header: \"" + paragraphTitles.get(i).getText() + "\"");
            }
        }
        return true;
    }
}
