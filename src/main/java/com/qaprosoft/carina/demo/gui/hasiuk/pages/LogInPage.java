package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class LogInPage extends GsmArenaPage {

    public LogInPage(WebDriver driver) {
        super(driver);
        setPageURL("/account.php3");
    }
}
