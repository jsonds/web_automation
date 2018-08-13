package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private By divBanner = By.className("home-hero-banner");
    private By lnkMyAcc = By.className("links-acc");
    private By lnkExclusiveProducts = By.xpath("//div[@class='nav-column']//a[contains(@class,'level1')][contains(text(),'Exclusive Range')]");
    private By lnkProducts = By.className("link-product");
    private By hdrExlcusiveRange = By.xpath("//strong[contains(text(),'Exclusive Range')]");


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

    public void mouseHoverOnProduct(){
        syscoLabUI.mouseHover(lnkProducts);
    }

    public void clickExclusiveBottlesLink(){
        syscoLabUI.click(lnkExclusiveProducts);
    }

    public boolean isExclusivePage(){
        return syscoLabUI.getText(hdrExlcusiveRange).contains("Exclusive Range");
    }
}
