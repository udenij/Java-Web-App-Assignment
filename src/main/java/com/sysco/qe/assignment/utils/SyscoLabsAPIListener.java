package com.sysco.qe.assignment.utils;


import com.google.gson.JsonObject;
import com.syscolab.qe.core.reporting.SyscoLabListener;
import com.syscolab.qe.core.reporting.SyscoLabReporting;
import org.testng.ITestResult;

public class SyscoLabsAPIListener extends SyscoLabListener {
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test PASSED");
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test FAILED");

        try {
            JsonObject element = SyscoLabReporting.getElement(iTestResult, null);
            elements.add(element);
        } catch (Exception e) {
            LoggerUtil.logERROR(e.getMessage(), e);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        LoggerUtil.logINFO("Test SKIPPED");

        try {
            JsonObject element = SyscoLabReporting.getElement(iTestResult, null);
            elements.add(element);
        } catch (Exception e) {
            LoggerUtil.logERROR(e.getMessage(), e);
        }
    }

}
