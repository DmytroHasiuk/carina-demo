package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.hasiuk.components.footer.Footer;
import com.qaprosoft.carina.demo.gui.hasiuk.components.header.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GsmArenaPage extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    @FindBy(id = "footer-side")
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
}
