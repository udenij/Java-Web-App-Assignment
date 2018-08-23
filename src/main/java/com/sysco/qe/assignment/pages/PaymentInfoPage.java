package com.sysco.qe.assignment.pages;

import org.openqa.selenium.By;

public class PaymentInfoPage extends DeliveryOptionPage {

    private By lblRadioCreditCard= By.xpath("//*[@id=\"checkout-payment-method-load\"]/div[2]/dt/label");
    private By txtCreditCardNumber=By.xpath("//*[@id=\"braintree_cc_number\"]");
    private By requiredMsg=By.xpath("//*[@id=\"advice-required-entry-braintree_cc_number\"]");
    private By expireMonth=By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[1]/div/div[2]/ul/li[10]");
    private By expireYear=By.xpath("//*[@id=\"payment_form_braintree\"]/li[4]/div/div[2]/div/div[1]/div[1]");
    private By txtCVV=By.xpath("//*[@id=\"braintree_cc_cid\"]");
    private By selectOption=By.xpath("//*[@id=\"agreement-1\"]");
    private By btnProcced=By.xpath("//*[@id=\"payment-method-button\"]/span/span");


    public String verifyCCDetails(String ccNumber,String cvv){
        syscoLabUI.sleep(3);

        syscoLabUI.driver.findElement(lblRadioCreditCard).click();
        syscoLabUI.driver.findElement(txtCreditCardNumber).sendKeys(ccNumber);
        syscoLabUI.driver.findElement(expireMonth).click();
        syscoLabUI.driver.findElement(expireYear).click();
        syscoLabUI.driver.findElement(txtCVV).sendKeys(cvv);
        syscoLabUI.driver.findElement(selectOption).click();
        syscoLabUI.driver.findElement(btnProcced).click();
        return syscoLabUI.driver.findElement(requiredMsg).getText();
    }
}
