package com.sysco.qe.assignment.tests;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.functions.AddCartItems;
import com.sysco.qe.assignment.functions.BrowseDefault;
import com.sysco.qe.assignment.functions.RemoveCartItems;
import com.sysco.qe.assignment.functions.VerifyMyAccount;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SyscoLabListener.class)
public class ShoppingCartTest extends LoginPageTest{

    @Test(description = "testcase1", alwaysRun = true, priority = 1)
    public void test_Verify_a_valid_User_can_log_into_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result1=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result1,true,"Success");
        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.verifyPassword("12345678");
        boolean result2=VerifyMyAccount.verifySuccessMessage();
        softAssert.assertEquals(result2,true,"Success");
        RemoveCartItems.removeCartItems();
        String error=RemoveCartItems.getlblEmptyCartError();
        softAssert.assertEquals(error,Constants.ERROR_MSG_EMPTY_CART);
        softAssert.assertAll();

    }
    @Test(description = "testcase2", alwaysRun = true, priority = 1)
    public void test_Verify_a_valid_User_can_add_items_to_cart_through_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result1=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result1,true,"Success");
        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.verifyPassword("12345678");
        boolean result2=VerifyMyAccount.verifySuccessMessage();
        softAssert.assertEquals(result2,true,"Success");
        RemoveCartItems.removeCartItems();
        String error=RemoveCartItems.getlblEmptyCartError();
        softAssert.assertEquals(error,Constants.ERROR_MSG_EMPTY_CART);
        AddCartItems.hoverListOfProducts();
        AddCartItems.clickItems();
        softAssert.assertAll();

    }


}
