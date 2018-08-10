package com.sysco.qe.assignment.pages;

import com.syscolab.qe.core.ui.web.SyscoLabWUI;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.interactions.Actions;

public class ShoppingCartPage extends DefaultPage{

    private By lblShoppingCart=By.xpath("//*[@id=\"quick-access-list\"]/li[2]/ul/li[3]/div/div[1]/span[2]");
    private By lblEmptyCartErrorMsg=By.xpath("//*[@id=\"topCartContent\"]/div/p[2]");
    private By btnCart=By.xpath("//*[@id=\"cartHeader\"]");
    private By linkRemove=By.xpath ("//*[contains(@id,'cartheader-item')]");



   public String getEmptyCartError(){
       syscoLabUI.sleep(2);
       return  syscoLabUI.getText(lblEmptyCartErrorMsg);
   }
    public static void acceptBrowserAlert() {
        Alert alert = syscoLabUI.driver.switchTo().alert();
        alert.accept();
    }

    public void removeShopCartItems() {
        int noOfItems = Integer.parseInt(syscoLabUI.getText(lblShoppingCart));

        if (noOfItems != 0) {
            for (int i = 1; i <= noOfItems; i++) {
                syscoLabUI.driver.findElement(btnCart).click();
                syscoLabUI.sleep(5);
                syscoLabUI.driver.findElement(linkRemove).click();
                syscoLabUI.sleep(2);
                acceptBrowserAlert();

            }
        }
        else{
                getEmptyCartError();
            }
            syscoLabUI.driver.findElement(btnCart).click();
            getEmptyCartError();


    }


}
