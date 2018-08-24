package com.sysco.qe.assignment.utils;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.functions.BrowseDefault;
import com.syscolab.qe.core.reporting.SyscoLabQCenter;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.Date;

public class TestBase {

    protected SoftAssert softAssert;
    private SyscoLabsAPIListener syscoLabsAPIListener;
    protected SyscoLabQCenter syscoLabQCenter;
    private long testSuiteDuration = 0;
    private long testSuiteStartTime = 0;

    @BeforeClass
    public void initClass() {
        testSuiteDuration = 0;
        testSuiteStartTime = new Date().getTime();
        syscoLabsAPIListener = new SyscoLabsAPIListener();
        syscoLabQCenter = new SyscoLabQCenter();
        syscoLabQCenter.setProjectName(Constants.PROJECT_NAME);
        syscoLabQCenter.setEnvironment(Constants.TEST_ENV);
        syscoLabQCenter.setRelease(Constants.TEST_RELEASE);

    }

    @BeforeClass
    public void initiateLogin(){
        BrowseDefault.loadDefaultPage();
    }


    @BeforeMethod()
    public void initMethod(Method method) {
        LoggerUtil.logINFO("Running test - " + method.getName());
        this.softAssert = new SoftAssert();
    }

    @AfterClass
    public void quitDriver(){
        BrowseDefault.quitDriver();
    }

   @AfterClass
    public void cleanUP(ITestContext iTestContext){
        testSuiteDuration = new Date().getTime() - testSuiteStartTime;
        try {
            if (Constants.UPDATE_Q_CENTER)
                SyscoLabReporting.generateJsonFile(syscoLabsAPIListener.getResults(), syscoLabQCenter, testSuiteDuration);

        } catch (Exception e) {
            LoggerUtil.logERROR("Exception",e);
        }
    }


}
