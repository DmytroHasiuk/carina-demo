package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.gui.hasiuk.components.common.phone.finder.PhoneFinderBlock;
import com.qaprosoft.carina.demo.gui.hasiuk.components.footer.FooterMenu;
import com.qaprosoft.carina.demo.gui.hasiuk.components.common.header.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class GsmArenaPage extends AbstractPage {

    @FindBy(id = "header")
    private Header header;

    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;

    @FindBy(xpath = "//div[@class='brandmenu-v2 light l-box clearfix']")
    private PhoneFinderBlock phoneFinderBlock;

    public GsmArenaPage(WebDriver driver) {
        super(driver);
    }

    public Header getHeader() {
        return header;
    }

    public FooterMenu getFooterMenu() {
        return footerMenu;
    }

    public PhoneFinderBlock getPhoneFinderBlock() {
        return phoneFinderBlock;
    }
}
