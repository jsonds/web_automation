package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.ExclusiveProductPage;

public class ExclusiveProduct {

    private static ExclusiveProductPage exclusiveProductPage = new ExclusiveProductPage();

    public static void clickOnFirstProductAndAddToCart(){
        exclusiveProductPage.clkFirstProductItemAndAddToCart();
    }
}
