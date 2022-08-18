package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class ContactPage extends GsmArenaPage{

    public ContactPage(WebDriver driver) {
        super(driver);
        setPageURL("/contact.php3");
    }
}
