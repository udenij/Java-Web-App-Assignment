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

}
