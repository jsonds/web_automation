package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.HomePage;
import org.openqa.selenium.By;

public class Home {
    private static HomePage homePage = new HomePage();

    public static boolean verifyPageLoaded(){
        return homePage.isHomePageBannerVisible();
    }
    public static void navigateToMyAcc(){
        homePage.navigateToMyAcc();
    }

    public static void clickExclusiveBottlesLink(){
        homePage.mouseHoverOnProduct();
        homePage.clickExclusiveBottlesLink();
    }

    public static boolean isExclusivePage(){
        return homePage.isExclusivePage();
    }

}
