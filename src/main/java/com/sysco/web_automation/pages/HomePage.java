package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By divBanner = By.className("home-hero-banner");
    private By lnkMyAcc = By.className("links-acc");
    private By btnLogin = By.id("send2");
    private By txtEmail = By.id("email");
    private By txtPassword = By.id("pass");

    public boolean isHomePageBannerVisible(){
        return isDisplayed(divBanner,5L);
    }

    public boolean isLoginBtnAvailable(){
            return isDisplayed(btnLogin,5L);
    }

    public void navigateToMyAcc() {
        try {
            Thread.sleep(3000);
            syscoLabUI.waitTillElementLoaded(lnkMyAcc);
            syscoLabUI.click(lnkMyAcc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
