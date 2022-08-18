package com.qaprosoft.carina.demo.gui.hasiuk.components.header;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.*;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class HeaderMenu extends AbstractUIObject {

    @FindBy(xpath = ".//li[1]/a")
    private ExtendedWebElement homeLink;

    @FindBy(xpath = ".//li[2]/a")
    private ExtendedWebElement newsLink;

    @FindBy(xpath = ".//li[3]/a")
    private ExtendedWebElement reviewsLink;

    @FindBy(xpath = ".//li[4]/a")
    private ExtendedWebElement videosLink;

    @FindBy(xpath = ".//li[5]/a")
    private ExtendedWebElement featuredLink;

    @FindBy(xpath = ".//li[6]/a")
    private ExtendedWebElement phoneFinderLink;

    @FindBy(xpath = ".//li[7]/a")
    private ExtendedWebElement dealsLink;

    @FindBy(xpath = ".//li[8]/a")
    private ExtendedWebElement merchLink;

    @FindBy(xpath = ".//li[9]/a")
    private ExtendedWebElement coverageLink;

    @FindBy(xpath = ".//li[10]/a")
    private ExtendedWebElement contactLink;

    public HeaderMenu(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isAllElementsPresent() {
        List<ExtendedWebElement> thisElement = List.of(homeLink, newsLink, reviewsLink, videosLink, featuredLink,
                phoneFinderLink, dealsLink, merchLink, coverageLink, contactLink);
        for (ExtendedWebElement element : thisElement) {
            if (!element.isPresent()) return false;
        }
        return true;
    }

    public HomePage clickHomeLink() {
        homeLink.click();
        HomePage homePage = new HomePage(getDriver());
        Assert.assertTrue(homePage.isPageOpened(), "Home page was not opened");
        return homePage;
    }

    public NewsPage clickNewsLink() {
        newsLink.click();
        NewsPage newsPage = new NewsPage(getDriver());
        Assert.assertTrue(newsPage.isPageOpened(), "News page was not opened");
        return newsPage;
    }

    public ReviewsPage clickReviewsLink() {
        reviewsLink.click();
        ReviewsPage reviewsPage = new ReviewsPage(getDriver());
        Assert.assertTrue(reviewsPage.isPageOpened(), "Reviews page was not opened");
        return reviewsPage;
    }

    public VideosPage clickVideosLink() {
        videosLink.click();
        VideosPage videosPage = new VideosPage(getDriver());
        Assert.assertTrue(videosPage.isPageOpened(), "Videos page was not opened");
        return videosPage;
    }

    public FeaturesPage clickFeaturesPage() {
        featuredLink.click();
        FeaturesPage featuresPage = new FeaturesPage(getDriver());
        Assert.assertTrue(featuresPage.isPageOpened(), "Features page was not opened");
        return featuresPage;
    }

    public PhoneFinderPage clickPhoneFinderLink() {
        phoneFinderLink.click();
        PhoneFinderPage phoneFinderPage = new PhoneFinderPage(getDriver());
        Assert.assertTrue(phoneFinderPage.isPageOpened(), "Phone finder page was not opened");
        return phoneFinderPage;
    }

    public DealsPage clickDealsLink() {
        dealsLink.click();
        DealsPage dealsPage = new DealsPage(getDriver());
        Assert.assertTrue(dealsPage.isPageOpened(), "Deals page was not opened");
        return dealsPage;
    }

    public MerchPage clickMerchLink() {
        merchLink.click();
        return new MerchPage(getDriver());
    }

    public CoveragePage clickCoverageLink() {
        coverageLink.click();
        CoveragePage coveragePage = new CoveragePage(getDriver());
        Assert.assertTrue(coveragePage.isPageOpened(), "Coverage page was not opened");
        return coveragePage;
    }

    public ContactPage clickContactLink() {
        contactLink.click();
        ContactPage contactPage = new ContactPage(getDriver());
        Assert.assertTrue(contactPage.isPageOpened(), "Contact page was not opened");
        return contactPage;
    }
}
