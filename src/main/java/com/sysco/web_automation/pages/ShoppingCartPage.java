package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    private By btnShoppingCart = By.id("cartHeader");



    public void clickShoppingCart(){
        syscoLabUI.click(btnShoppingCart);
    }


}
