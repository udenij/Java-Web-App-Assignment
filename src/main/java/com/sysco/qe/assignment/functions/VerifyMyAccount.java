package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.pages.MyAccountPage;

public class VerifyMyAccount {

    private VerifyMyAccount(){}
    private static MyAccountPage myAccountPage = new MyAccountPage();

    public static void navigateToMyAccountPage(){
        myAccountPage.navigateToMyAccountPage();
    }

    public static boolean verifyLogin(){
        return myAccountPage.verifyLoginButton();
    }

    public static void verifyEmail(String mail){
        myAccountPage.validateEmail(mail);
    }

    public static void verifyPassword(String password){
        myAccountPage.validatePassword(password);
    }

    public static String getEmailErrorMsg(){
        return myAccountPage.getLblEmailError();
    }

    public static String getLoginError(){
        return myAccountPage.getLblLoginError();
    }

    public static void clickOnLogin(){
        myAccountPage.clickLogin();
    }
    public static String getPasswordErrorMsg(){
        return myAccountPage.getLblPasswordError();
    }

    public static String getEmptyPasswordErrorMsg(){
        return myAccountPage.getLblEmptyPswrdErrorMsg();
    }

    public static boolean verifySuccessMessage(){
        return myAccountPage.verifyWelcomeMessage();

    }

}
