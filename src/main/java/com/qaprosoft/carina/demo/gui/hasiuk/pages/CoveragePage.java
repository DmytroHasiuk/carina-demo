package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class CoveragePage extends GsmArenaPage{

    public CoveragePage(WebDriver driver) {
        super(driver);
        setPageURL("/network-bands.php3");
    }
}
