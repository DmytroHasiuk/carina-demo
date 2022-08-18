package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class VideosPage extends GsmArenaPage{

    public VideosPage(WebDriver driver) {
        super(driver);
        setPageURL("/videos.php3");
    }
}
