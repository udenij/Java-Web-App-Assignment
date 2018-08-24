package com.sysco.qe.assignment.pages;

import org.openqa.selenium.By;

public class MyAccountPage extends DefaultPage {

    private By linkMyAccount=By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li/a");
    private By btnLogin=By.xpath("//*[@id=\"send2\"]/span/span");
    private By txtEmail=By.xpath("//*[@id=\"email\"]");
    private By txtPassword=By.xpath("//*[@id=\"pass\"]");
    private By lblEmailErrorMsg=By.xpath("//*[@id=\"advice-validate-email-email\"]");
    private By lblLoginErrorMsg=By.xpath("/html/body/div[3]/div[3]/div[2]/div/div/ul/li/ul/li/span");
    private By lblPassowrdErrorMsg=By.xpath("//*[@id=\"advice-validate-password-pass\"]");
    private By lblEmptyPasswordErrorMsg=By.xpath("//*[@id=\"advice-required-entry-pass\"]");
    private By lblWelcomeMsg=By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[1]/h2");
    private By lblUserName=By.xpath("/html/body/div[2]/div[3]/div[2]/div[1]/div/div[3]/div[2]/div[1]/div/p");

    public void navigateToMyAccountPage(){
        syscoLabUI.sleep(5);
        syscoLabUI.driver.findElement(linkMyAccount).click();

    }
    public boolean verifyLoginButton(){
        syscoLabUI.sleep(5);
        if(syscoLabUI.driver.findElement(btnLogin).isDisplayed()){
            return true;
        }
        else
            return false;
    }

    public void validateEmail(String email){
        syscoLabUI.driver.findElement(txtEmail).sendKeys(email);
        syscoLabUI.sleep(2);
        syscoLabUI.driver.findElement(txtPassword).click();
    }

    public void validatePassword(String password){
        syscoLabUI.driver.findElement(txtPassword).sendKeys(password);
        syscoLabUI.sleep(2);
        syscoLabUI.driver.findElement(btnLogin).click();
    }

    public String getLblEmailError(){
        syscoLabUI.sleep(2);
        return syscoLabUI.getText(lblEmailErrorMsg);
    }
    public String getLblLoginError(){
        syscoLabUI.sleep(2);
        return syscoLabUI.getText(lblLoginErrorMsg);
    }

    public void clickLogin(){
        syscoLabUI.driver.findElement(btnLogin).click();
    }
    public String getLblPasswordError(){
        return syscoLabUI.getText(lblPassowrdErrorMsg);
    }
    public String getLblEmptyPswrdErrorMsg(){
        return syscoLabUI.getText(lblEmptyPasswordErrorMsg);
    }

    public boolean verifyWelcomeMessage(){
        syscoLabUI.sleep(5);
        if(syscoLabUI.driver.findElement(lblWelcomeMsg).isDisplayed()){
            return true;
        }
        else
            return false;
    }
    public boolean verifyUserName(){
        syscoLabUI.sleep(5);
        if(syscoLabUI.driver.findElement(lblUserName).isDisplayed()){
            return true;
        }
        else
            return false;
    }

    public void clearLoginFileds(){
        syscoLabUI.driver.findElement(txtEmail).clear();
        syscoLabUI.driver.findElement(txtPassword).clear();
    }

}
