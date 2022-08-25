package com.qaprosoft.carina.demo.gui.hasiuk.components.phoneFinder;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.gui.hasiuk.pages.phone.finder.page.ResultPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ShowButton extends AbstractUIObject {

    @FindBy(className = "pf-button")
    private ExtendedWebElement submitPart;

    @FindBy(id = "pf-results")
    private ExtendedWebElement infoPart;

    public ShowButton(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getButtonText() {
        return infoPart.getText();
    }

    public ResultPage click() {
        ResultPage resultPage = new ResultPage(getDriver());
        submitPart.click();
        Assert.assertTrue(resultPage.isPageOpened(), "Result page was not opened");
        return resultPage;
    }

    public boolean isPresent() {
        return (submitPart.isPresent() && infoPart.isPresent());
    }
}
