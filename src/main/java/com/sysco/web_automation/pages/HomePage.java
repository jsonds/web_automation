package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By divBanner = By.className("home-hero-banner");

    public boolean isHomePageBannerVisible(){
        return isDisplayed(divBanner,10L);
    }
}
