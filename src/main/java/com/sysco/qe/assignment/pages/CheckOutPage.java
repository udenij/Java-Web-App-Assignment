package com.sysco.qe.assignment.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

public class CheckOutPage extends ProductPage {


    private By txtFirstName=By.xpath("//*[@id=\"billing:firstname\"]");
    private By txtLastName=By.xpath("//*[@id=\"billing:lastname\"]");
    private By lblRequiredFnamMsg=By.xpath("//*[@id=\"advice-required-entry-billing:firstname\"]");
    private By btnContinue=By.xpath("//*[@id=\"delivery-address-button\"]/span/span");
    private By btnRemovePostCode=By.xpath("//*[@id=\"billing:postcodesuburbremove\"]");
    private By txtPostCode=By.xpath("//*[@id=\"billing:postcodesuburb\"]");
    private By drpDwnPostCode=By.xpath("//*[@id=\"Autocomplete_billing:postcodesuburb\"]/div[1]");


    public boolean verifyName(String fname1, String lname1){
        String fname2=syscoLabUI.driver.findElement(txtFirstName).getAttribute("value");
        String lname2=syscoLabUI.driver.findElement(txtLastName).getAttribute("value");
        if((fname1.equals(fname2)&&(lname1.equals(lname2)))){
            return true;
        }
        else
            return false;
    }
    public String clickContinue(){
        syscoLabUI.driver.findElement(txtFirstName).clear();
        syscoLabUI.driver.findElement(btnContinue).click();
        return syscoLabUI.driver.findElement(lblRequiredFnamMsg).getText();
    }

    public void setFirstName(String fname){
        syscoLabUI.driver.findElement(txtFirstName).sendKeys(fname);
        syscoLabUI.sleep(2);
    }
    public void acceptBrowserAlert() {
        Alert alert = syscoLabUI.driver.switchTo().alert();
        alert.accept();
    }


    public void enterPostCode(String code){
        syscoLabUI.driver.findElement(btnRemovePostCode).click();
        syscoLabUI.driver.findElement(txtPostCode).click();
        syscoLabUI.driver.findElement(txtPostCode).click();
        //acceptBrowserAlert();
        syscoLabUI.driver.findElement(txtPostCode).sendKeys(code);
        syscoLabUI.sleep(3);
        syscoLabUI.driver.findElement(drpDwnPostCode).click();
        syscoLabUI.driver.findElement(btnContinue).click();
    }

}
