package com.sysco.qe.assignment.tests;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.functions.*;
import com.sysco.qe.assignment.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SyscoLabListener.class)
public class BundabergumTest extends TestBase {

    @BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "Bundabergrum - Checkout");
        syscoLabQCenter.setModule(Constants.BUNDABERGUM);
        syscoLabQCenter.setFeature(Constants.BUNDABERGUM + " - "+Constants.CHECKOUT);
        syscoLabQCenter.setClassName(BundabergumTest.class.getName());


    }



    @Test(description = "testcase1", alwaysRun = true, priority = 1)
    public void test_Verify_an_Invalid_user_of_age_less_than_18_can_not_access_bundaberg_application() throws Exception {

        BrowseDefault.setBirthDay("7","March","2003");
        BrowseDefault.hitEntetr();
        String message=BrowseDefault.getLblLoginError();
        softAssert.assertEquals(message,Constants.ERROR_MSG_ACESS_DENIED,"Invalid Error Message");
        softAssert.assertAll();

    }

    @Test(description = "testcase3", alwaysRun = true, priority = 2)
    public void test_Verify_a_valid_user_of_age_greater_than_18_can_access_bundaberg_application() throws Exception {

        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        boolean result=BrowseDefault.successPageNavigation();
        softAssert.assertEquals(result,true,"Success");
        softAssert.assertAll();

    }

    @Test(description = "testcase4", alwaysRun = true, priority = 3)
    public void test_Verify_a_valid_user_has_access_to_login_button_through_bundaberg_application() throws Exception {
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        softAssert.assertAll();

    }
    @Test(description = "testcase5", alwaysRun = true, priority = 4)
    public void test_Verify_a_valid_email_can_be_enterd_through_bundaberg_application() throws Exception {
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        VerifyMyAccount.verifyEmail("test.123");
        String error=VerifyMyAccount.getEmailErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_INVALID_EMAIL,"Invalid Error Message");
        VerifyMyAccount.clearLoginFields();
        softAssert.assertAll();

    }
    @Test(description = "testcase6", alwaysRun = true, priority = 5)
    public void test_Verify_a_valid_Email_and_password_can_be_enterd_through_bundaberg_application() throws Exception {

        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.verifyPassword("123");
        VerifyMyAccount.clickOnLogin();
        String error=VerifyMyAccount.getPasswordErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_INVALID_PWRD,"Invalid Error Message");
        VerifyMyAccount.clearLoginFields();
        softAssert.assertAll();

    }
    @Test(description = "testcase7", alwaysRun = true, priority = 6)
    public void test_Verify_a_valid_Email_and_Empty_Password_field_do_not_allow_through_bundaberg_application() throws Exception {

        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.clickOnLogin();
        String error=VerifyMyAccount.getEmptyPasswordErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_REQUIRED_FIELD,"Invalid Error Message");
        VerifyMyAccount.clearLoginFields();
        softAssert.assertAll();

    }
    @Test(description = "testcase1", alwaysRun = true, priority = 7)
    public void test_Verify_a_valid_User_can_log_into_bundaberg_application() throws Exception {
        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.verifyPassword("12345678");
        boolean result2=VerifyMyAccount.verifySuccessMessage();
        softAssert.assertEquals(result2,true,"Success");
        RemoveCartItems.removeCartItems();
        String error=RemoveCartItems.getlblEmptyCartError();
        softAssert.assertEquals(error,Constants.ERROR_MSG_EMPTY_CART);
        softAssert.assertAll();

    }
    @Test(description = "testcase2", alwaysRun = true, priority = 8)
    public void test_Verify_a_valid_User_can_add_items_to_cart_through_bundaberg_application() throws Exception {
        AddCartItems.hoverListOfProducts();
        AddCartItems.clickItems();
        String itemName=AddCartItems.getSelectedItemName();
        String itemPrice=AddCartItems.getSelectedItemPrice();
        AddCartItems.addItemsToCart();
        String cartContainItemName=AddCartItems.getCartContentItemName();
        String cartContainItemPrice=AddCartItems.getCartContentItemPrice();
        boolean result3=AddCartItems.itemContetntVerification(itemName,itemPrice,cartContainItemName,cartContainItemPrice);
        softAssert.assertEquals(result3,true,"valid Content");
        AddCartItems.clickOnCheckOutAndProceed();
        boolean result4=VerificationCheckout.verifyFirstAndLastName("william","jacob");
        softAssert.assertEquals(result4,true,"success");
        String result5=VerificationCheckout.clickOnContinue();
        softAssert.assertEquals(result5,Constants.ERROR_MSG_REQUIRED_FIELD,"Invalid message");
        VerificationCheckout.resetFirstName("william");
        VerificationCheckout.enterThePassCode("2000");
        boolean result6=VerifyDeliveryOption.verifyDeliveryOptionMessage();
        softAssert.assertEquals(result6,Constants.DELIVERY_OPTION_MSG,"Success Message");
        boolean result7=VerifyDeliveryOption.verifyDeliveryOptionMessage();
        softAssert.assertEquals(result7,true,"Invalid Message");
        //String error2=PaymentVerification.verifyCreditCardCredentials("12345678","12345");
        //softAssert.assertEquals(error2,Constants.ERROR_INAVLID_CC_NUMBER,"Invalid Error message");
        softAssert.assertAll();

    }




}
