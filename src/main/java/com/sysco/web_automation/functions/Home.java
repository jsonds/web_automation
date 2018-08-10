package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.HomePage;

public class Home {
    private static HomePage homePage = new HomePage();

    public static boolean verifyPageLoaded(){
        return homePage.isHomePageBannerVisible();
    }
    public static void navigateToMyAcc(){
        homePage.navigateToMyAcc();
    }


}
