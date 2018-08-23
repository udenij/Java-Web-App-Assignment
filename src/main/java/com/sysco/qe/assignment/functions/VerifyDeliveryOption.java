package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.pages.DeliveryOptionPage;

public class VerifyDeliveryOption {
    private VerifyDeliveryOption(){}
    private static DeliveryOptionPage deliveryOptionPage=new DeliveryOptionPage();

    public static boolean verifyDeliveryOptionMessage(){
        return deliveryOptionPage.validateDeliveryOption();
    }
}
