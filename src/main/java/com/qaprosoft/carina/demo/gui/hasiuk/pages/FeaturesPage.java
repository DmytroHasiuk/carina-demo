package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class FeaturesPage extends GsmArenaPage{

    public FeaturesPage(WebDriver driver) {
        super(driver);
        setPageURL("/news.php3?sTag=Featured");
    }
}
