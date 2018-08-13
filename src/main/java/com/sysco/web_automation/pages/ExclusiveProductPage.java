package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class ExclusiveProductPage extends BasePage {

    private By divFirstProductItem = By.xpath("//div[@class='category-products list']//ul//li[1]");
    private By divAddToCart = By.xpath("//button[@title='Add to Cart']");

    public void clkFirstProductItemAndAddToCart(){
        syscoLabUI.click(divFirstProductItem);
        syscoLabUI.click(divAddToCart);
    }

}
