package com.sysco.qe.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends ShoppingCartPage {


    private By linkProducts=By.xpath("//*[@id=\"nav-wrapper\"]/div/ul[1]/li[1]/a");
    private By linkItem=By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[5]/a");
    private By linkViewMore=By.xpath("//*[@id=\"main-image\"]/img");
    private By btnAddToCart=By.xpath("//*[@id=\"price-inner-content\"]/div[2]/div/div[2]/button/span/span");
    private By lblItemName=By.xpath("//*[@id=\"product-info\"]/div/div[1]/h1");
    private By lblItemPrice=By.xpath("//*[@id=\"product-price-695\"]/span");

    public void hoverProductList(){
        Actions builder = new Actions(syscoLabUI.driver);
        syscoLabUI.sleep(5);
        builder.moveToElement(syscoLabUI.driver.findElement(linkProducts)).build().perform();
    }

    public String getItemName(){
        return syscoLabUI.driver.findElement(lblItemName).getText();
    }

    public String getItemPrice(){
        return syscoLabUI.driver.findElement(lblItemPrice).getText();
    }

    public void clickItem(){
        syscoLabUI.driver.findElement(linkItem).click();
        syscoLabUI.sleep(4);
        syscoLabUI.driver.findElement(linkViewMore).click();
        getItemName();
        getItemPrice();
    }


    public void addToCart(){
        syscoLabUI.sleep(3);
        syscoLabUI.driver.findElement(btnAddToCart).click();
    }


}
