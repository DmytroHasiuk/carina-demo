package com.qaprosoft.carina.demo.gui.hasiuk.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends GsmArenaPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LogInPage loginUser(String email, String password) {
        getHeader().getSocialConnectPanel().clickLogInLink();
        return getHeader().getSocialConnectPanel().getLoginPopUpMenu().loginUser(email, password);
    }

    public boolean isUserLogin() {
        return getHeader().getSocialConnectPanel().isUserLogIn();
    }

    public boolean isUserNicknameWright(String nickname) {
        getHeader().clickLinesButton();
        return getHeader().getSocialConnectPanel().isUserNicknameWright(nickname);
    }
}
