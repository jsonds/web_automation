package com.sysco.web_automation.functions;

import com.sysco.web_automation.pages.ShoppingCartPage;

public class ShoppingCart {
    public static ShoppingCartPage shoppingCartPage = new ShoppingCartPage();

    public static void removeItemsFromShoppingCart(){
        shoppingCartPage.removeItemsFromShoppingCart();
    }
    public static int getShoppingCartItemCount(){
        return shoppingCartPage.getShoppingCartItemCount();
    }

    public static void moveToShoppingCart(){
        shoppingCartPage.clickShoppingCart();
    }

    public static boolean isShoppingCartEmpty(){
        return shoppingCartPage.isShoppingCartEmpty();
    }

/*    public static String getItemName(){
        return
    }

    public static double getItemPrice(){

    }*/
}
