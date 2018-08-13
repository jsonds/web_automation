package com.sysco.web_automation.pages;

import org.openqa.selenium.By;

public class ShoppingCartPage extends BasePage {

    private By btnShoppingCart = By.id("cartHeader");
    private By lblCartItemCount = By.xpath("//div[@class='block-title']//span[@class='orange']");
    private By divNoItems = By.xpath("//div[@class='block-title no-items']");
    private By lnkRemoveItem = By.xpath("//a[@class='btn-remove']");
    private By divCartEmpty = By.xpath("//p[@class='cart-empty']");


    public void clickShoppingCart(){
        syscoLabUI.click(btnShoppingCart);
    }

    public boolean isShoppingCartEmpty(){
        return syscoLabUI.isDisplayed(divCartEmpty);
    }

    public int getShoppingCartItemCount(){

        if(syscoLabUI.isDisplayed(divNoItems))
            return 0;
        sleepFor(5);
        int numberOfItemsInCart = Integer.parseInt(syscoLabUI.getText(lblCartItemCount));
        return numberOfItemsInCart;

    }

    public void clickRemoveItem(){
        syscoLabUI.click(lnkRemoveItem);

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
