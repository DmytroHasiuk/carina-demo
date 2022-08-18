package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class ReviewsPage extends GsmArenaPage{

    public ReviewsPage(WebDriver driver) {
        super(driver);
        setPageURL("/reviews.php3");
    }
}
