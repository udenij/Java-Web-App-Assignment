package com.sysco.qe.assignment.functions;


import com.sysco.qe.assignment.pages.ShoppingCartPage;

public class RemoveCartItems {

    private RemoveCartItems(){}
    private static ShoppingCartPage shoppingCartPage  = new ShoppingCartPage();

    public static void removeCartItems()
    {
        shoppingCartPage.removeShopCartItems();
    }

    public static String getlblEmptyCartError(){
        return shoppingCartPage.getEmptyCartError();
    }

}
