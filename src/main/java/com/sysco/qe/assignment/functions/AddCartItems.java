package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.pages.ProductPage;


public class AddCartItems {

    private AddCartItems(){}
    private static ProductPage productPage=new ProductPage();

    public static void hoverListOfProducts()
    {
        productPage.hoverProductList();
    }

    public static void clickItems(){
        productPage.clickItem();
    }

    public static String getCartContentItemName(){
        String itemName=productPage.getCartItemName();
        return itemName;
    }
    public static String getCartContentItemPrice(){
        String itemPrice=productPage.getCartItemPrice();
        return itemPrice;
    }
    public static String getSelectedItemName(){
        String name=productPage.getItemName();
        return name;
    }
    public static String getSelectedItemPrice(){
        String price=productPage.getItemPrice();
        return price;
    }

    public static boolean itemContetntVerification(String selectedName,String selectedPrice,String cartItemName,String cartItemPrice ){

        if((selectedName.equals(cartItemName)) && (selectedPrice.equals(cartItemPrice))){
            return true;
        }
        else{
            return false;
        }
    }

    public static void addItemsToCart(){
        productPage.addToCart();
    }

    public static void clickOnCheckOutAndProceed(){
        productPage.clickCheckOut();
    }

}
