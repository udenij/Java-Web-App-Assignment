package com.sysco.qe.assignment.tests;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.functions.BrowseDefault;
import com.sysco.qe.assignment.functions.RemoveCartItems;
import com.sysco.qe.assignment.functions.VerifyMyAccount;
import com.sysco.qe.assignment.pages.DefaultPage;
import com.sysco.qe.assignment.utils.TestBase;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(SyscoLabListener.class)
public class LoginPageTest extends TestBase {

    /*@BeforeClass
    public void init(ITestContext iTestContext) {
        iTestContext.setAttribute("feature", "PCPricing - MassUpload");
        syscoLabQCenter.setModule(Constants.PCPRICING);
        syscoLabQCenter.setFeature(Constants.PCPRICING + " - " + Constants.MASSUPLOAD);
        syscoLabQCenter.setClassName(LoginPageTest.class.getName());


    }
    */


    @Test(description = "testcase1", alwaysRun = true, priority = 1)
    public void test_Verify_an_Invalid_user_of_age_less_than_18_can_not_access_bundaberg_application() throws Exception {

        BrowseDefault.setBirthDay("7","March","2003");
        BrowseDefault.hitEntetr();
        String message=BrowseDefault.getLblLoginError();
        softAssert.assertEquals(message,Constants.ERROR_MSG_ACESS_DENIED,"Invalid Error Message");
        softAssert.assertAll();

    }

    @Test(description = "testcase2", alwaysRun = true, priority = 2)
    public void test_Verify_birthdate_can_not_be_empty_to_access_bundaberg_application() throws Exception {
        BrowseDefault.hitEntetr();
        String message=BrowseDefault.getLblEmptyMsg();
        softAssert.assertEquals(message,Constants.ERROR_MSG_EMPTY_BITHDATE,"Invalid Error Message");
        softAssert.assertAll();

    }
    @Test(description = "testcase3", alwaysRun = true, priority = 3)
    public void test_Verify_a_valid_user_of_age_greater_than_18_can_access_bundaberg_application() throws Exception {

        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        boolean result=BrowseDefault.successPageNavigation();
        softAssert.assertEquals(result,true,"Success");
        softAssert.assertAll();

    }

    @Test(description = "testcase4", alwaysRun = true, priority = 4)
    public void test_Verify_a_valid_user_has_access_to_login_button_through_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        softAssert.assertAll();

    }
    @Test(description = "testcase5", alwaysRun = true, priority = 5)
    public void test_Verify_a_valid_email_can_be_enterd_through_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        VerifyMyAccount.verifyEmail("test.123");
        String error=VerifyMyAccount.getEmailErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_INVALID_EMAIL,"Invalid Error Message");
        softAssert.assertAll();

    }
    @Test(description = "testcase6", alwaysRun = true, priority = 6)
    public void test_Verify_a_valid_Email_and_password_can_be_enterd_through_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.verifyPassword("123");
        VerifyMyAccount.clickOnLogin();
        String error=VerifyMyAccount.getPasswordErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_INVALID_PWRD,"Invalid Error Message");
        softAssert.assertAll();

    }
    @Test(description = "testcase7", alwaysRun = true, priority = 7)
    public void test_Verify_a_valid_Email_and_Empty_Password_field_do_not_allow_through_bundaberg_application() throws Exception {
        BrowseDefault.setBirthDay("7","March","1991");
        BrowseDefault.hitEntetr();
        VerifyMyAccount.navigateToMyAccountPage();
        boolean result=VerifyMyAccount.verifyLogin();
        softAssert.assertEquals(result,true,"Success");
        VerifyMyAccount.verifyEmail("williamjacob802@gmail.com");
        VerifyMyAccount.clickOnLogin();
        String error=VerifyMyAccount.getEmptyPasswordErrorMsg();
        softAssert.assertEquals(error,Constants.ERROR_MSG_REQUIRED_FIELD,"Invalid Error Message");
        softAssert.assertAll();

    }




}
