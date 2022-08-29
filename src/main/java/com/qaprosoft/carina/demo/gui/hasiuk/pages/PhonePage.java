package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.gui.hasiuk.components.phone.page.Comment;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PhonePage extends GsmArenaPage {

    @FindBy(xpath = "//h1")
    private ExtendedWebElement articleName;

    @FindBy(xpath = "//li[@class='article-info-meta-link light'][4]")
    private ExtendedWebElement opinionsTab;

    @FindBy(id = "sort-comments")
    private ExtendedWebElement sortComments;

    @FindBy(xpath = "//div[@class='user-thread']")
    private List<Comment> comments;

    public PhonePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened(String phone) {
        return (articleName.isPresent() && StringUtils.equalsIgnoreCase(phone, articleName.getText()));
    }

    public void clickOpinionsTab() {
        opinionsTab.click();
    }

    public void sortByBestRating() {
        sortComments.select("Best rating");
    }

    public void sortNewestFirst() {
        sortComments.select("Newest first");
    }

    public boolean isCommentsSortedByPopularity() {
        List<Integer> commentVotes = comments.stream().map(Comment::getVotesQuantity).collect(Collectors.toList());
        return Collections.max(commentVotes).equals(commentVotes.get(0));
    }

    public boolean isCommentsSortedByData() {
        List<Date> commentDates = comments.stream().map(Comment::getTimeOfPublication).collect(Collectors.toList());
        return Collections.max(commentDates).equals(commentDates.get(0));
    }

    public void clickRateButton(Comment comment) {
        comment.clickUvoteButton();
        comment.clickVoteButton();
    }

    public Comment getComment(int number) {
        return comments.get(number);
    }
}
