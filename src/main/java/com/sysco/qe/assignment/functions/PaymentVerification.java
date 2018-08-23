package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.pages.PaymentInfoPage;

public class PaymentVerification {
    private PaymentVerification(){}
    private static PaymentInfoPage paymentInfoPage  = new PaymentInfoPage();

    public static String verifyCreditCardCredentials(String ccNumber,String cvv){
        return paymentInfoPage.verifyCCDetails(ccNumber,cvv);
    }

}
