package com.sysco.qe.assignment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ProductPage extends ShoppingCartPage {


    private By linkProducts=By.xpath("//*[@id=\"nav-wrapper\"]/div/ul[1]/li[1]/a");
    private By linkItem=By.xpath("//*[@id=\"nav-wrapper\"]/div/div[4]/div[1]/div[1]/ul/li/ul/li[5]/a");
    private By linkViewMore=By.xpath("//*[@id=\"product-tracking-697\"]");
    private By btnAddToCart=By.xpath("//*[@id=\"price-inner-content\"]/div[2]/div/div[2]/button/span/span");
    private By lblItemName=By.xpath("//*[@id=\"product-info\"]/div/div[1]/h1");
    private By lblItemPrice=By.xpath("//*[@id=\"product-price-697\"]/span");
    private By lblCartItemName=By.xpath("//*[@id=\"mini-cart\"]/li/div/p/a");
    private By lblCartItemPrice=By.xpath("//*[@id=\"mini-cart\"]/li[1]/div/table/tbody/tr[2]/td/span");
    private By linkCart=By.xpath("//*[@id=\"cartHeader\"]");
    private By btnCheckout=By.xpath("//*[@id=\"topCartContent\"]/div/div/div/button/span/span");
    private By btnproceedCheckOut=By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[1]/div[1]/div/ul/li[2]/button/span/span");

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

    public String getCartItemName(){
        syscoLabUI.sleep(4);
        syscoLabUI.refreshBrowser();
        syscoLabUI.click(linkCart);
        syscoLabUI.sleep(2);
        return syscoLabUI.driver.findElement(lblCartItemName).getText();
    }

    public String getCartItemPrice(){
        return syscoLabUI.driver.findElement(lblCartItemPrice).getText();
    }



    public void clickItem(){
        syscoLabUI.driver.findElement(linkItem).click();
        syscoLabUI.sleep(4);
        syscoLabUI.driver.findElement(linkViewMore).click();
        }


    public void addToCart(){
        syscoLabUI.driver.findElement(btnAddToCart).click();
    }

    public void clickCheckOut(){
        syscoLabUI.driver.findElement(btnCheckout).click();
        syscoLabUI.sleep(2);
        syscoLabUI.driver.findElement(btnproceedCheckOut).click();
    }


}
