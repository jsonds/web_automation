package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By divBanner = By.className("home-hero-banner");
    private By lnkMyAcc = By.className("links-acc");

    public boolean isHomePageBannerVisible(){
        return isDisplayed(divBanner,5L);
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
