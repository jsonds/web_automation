package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class ProductPage extends BasePage {

    private By divProductName = By.xpath("");
    private By spnProductPrice = By.xpath("");


    public String getProductName(){
        return syscoLabUI.getValue(divProductName);
    }

    public String getProductPrice(){
        return syscoLabUI.getValue(spnProductPrice);
    }
}
