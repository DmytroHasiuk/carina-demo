package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class DealsPage extends GsmArenaPage{

    public DealsPage(WebDriver driver) {
        super(driver);
        setPageURL("/deals.php3");
    }
}
