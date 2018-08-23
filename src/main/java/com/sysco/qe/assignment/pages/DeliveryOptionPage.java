package com.sysco.qe.assignment.pages;

import org.openqa.selenium.By;

public class DeliveryOptionPage extends CheckOutPage {

    private By lblDeliveryConfirm= By.xpath("//*[@id=\"co-shipping-method-form\"]/div[2]/div/p/span");
    private By btnContinue=By.xpath("//*[@id=\"shipping-method-button\"]/span/span");
    private By btnSelectOption=By.xpath("//*[@id=\"ns-checkout-shipping-authorize_mm\"]");

    public boolean validateDeliveryOption(){
        if(syscoLabUI.driver.findElement(lblDeliveryConfirm).isDisplayed()){
            syscoLabUI.driver.findElement(btnSelectOption).click();
            syscoLabUI.driver.findElement(btnContinue).click();
            return true;
        }
        else
            return false;
    }
}
