package com.qaprosoft.carina.demo.gui.hasiuk.components.phone.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.exceptions.WrongDataException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Pattern;

public class Comment extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = ".//time")
    private ExtendedWebElement dataOfPublication;

    @FindBy(xpath = ".//ul[@class='votes']")
    private ExtendedWebElement votes;

    @FindBy(xpath = ".//li[@class='uvote button']")
    private ExtendedWebElement uvoteButton;

    @FindBy(xpath = ".//span[@data-code='1']")
    private ExtendedWebElement voteButton;

    public Comment(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public Date getTimeOfPublication() throws WrongDataException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd MMM y", Locale.ENGLISH);
            return formatter.parse(dataOfPublication.getText());
        } catch (ParseException e) {
            if (Pattern.matches("^\\d* hours ago$", dataOfPublication.getText())) {
                if (Character.toString(dataOfPublication.getText().charAt(1)).equals(" ")) {
                    int hours = Integer.parseInt(Character.toString(dataOfPublication.getText().charAt(0)));
                    Date date = new Date();
                    return (new Date(date.getTime() - (hours * 3600000L)));
                } else {
                    int hours = Integer.parseInt(dataOfPublication.getText().substring(0,2));
                    Date date = new Date();
                    return (new Date(date.getTime() - (hours * 3600000L)));
                }
            } else {
                LOGGER.error(e.getMessage());
                throw new WrongDataException();
            }
        }
    }

    public int getVotesQuantity() {
        return Integer.parseInt(votes.getAttribute("data-votes"));
    }

    public void clickUvoteButton() {
        dataOfPublication.scrollTo();
        uvoteButton.click();
    }

    public void clickVoteButton() {
        voteButton.scrollTo();
        voteButton.click();
    }
}
