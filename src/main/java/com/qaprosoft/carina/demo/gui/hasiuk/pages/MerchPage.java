package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public class MerchPage extends AbstractPage {
    public MerchPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://merch.gsmarena.com");
    }
}
