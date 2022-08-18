package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.hasiuk.components.footer.Footer;
import com.qaprosoft.carina.demo.gui.hasiuk.components.header.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public abstract class GsmArenaPage extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    @FindBy(id = "footer")
    private Footer footer;

    public GsmArenaPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public Footer getFooter() {
        return footer;
    }

    public void switchToSecondTab(){
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs .get(1));
    }

    public void closeCurrentTab(){
        getDriver().close();
    }

    public void switchToFirstTab(){
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(browserTabs .get(0));
    }

    public boolean isTabClosed(){
        List<String> browserTabs = new ArrayList<>(getDriver().getWindowHandles());
        return browserTabs.size() == 1;
    }
}
