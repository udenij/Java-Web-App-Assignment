package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.pages.CheckOutPage;

public class VerificationCheckout {
    private VerificationCheckout(){}
    private static CheckOutPage checkOutPage=new CheckOutPage();

    public static boolean verifyFirstAndLastName(String fname,String lname){
        return checkOutPage.verifyName(fname,lname);
    }

    public static String  clickOnContinue(){
        return checkOutPage.clickContinue();
    }

    public static void resetFirstName(String fname){
        checkOutPage.setFirstName(fname);
    }

    public static void enterThePassCode(String code){
        checkOutPage.enterPostCode(code);
    }
}
