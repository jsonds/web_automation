package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    private By btnShoppingCart = By.id("cartHeader");
    //private By lblCartItemCount = By.xpath("//span[@class='orange'][contains(text(),'1')]");
    private By lblCartItemCount = By.xpath("//div[@class='block-title']//span[@class='orange']");
    private By divNoItems = By.xpath("//div[@class='block-title no-items']");
    private By lnkRemoveItem = By.xpath("//a[@class='btn-remove']");



    public void clickShoppingCart(){
        syscoLabUI.click(btnShoppingCart);
    }

    public int getShoppingCartItemCount(){
        if(syscoLabUI.isDisplayed(divNoItems))
            return 0;
        return Integer.parseInt(syscoLabUI.getText(lblCartItemCount));

    }

    public void clickRemoveItem(){
        syscoLabUI.clear(lnkRemoveItem);

    }

    public void removeItemsFromShoppingCart(){
        while (getShoppingCartItemCount() != 0) {
                //remove items from cart
                clickShoppingCart();
                sleepFor(1);
                isDisplayed(lnkRemoveItem, 1L);
                //syscoLabUI.click(lnkRemoveItem);
                clickRemoveItem();
                syscoLabUI.clickOkInWindowsAlert();
            }
        }

}
