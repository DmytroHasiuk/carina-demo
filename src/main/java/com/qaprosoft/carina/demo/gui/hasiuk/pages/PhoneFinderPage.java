package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class PhoneFinderPage extends GsmArenaPage{

    public PhoneFinderPage(WebDriver driver) {
        super(driver);
        setPageURL("/search.php3?");
    }
}
