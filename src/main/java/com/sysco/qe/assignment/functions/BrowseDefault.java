package com.sysco.qe.assignment.functions;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.pages.DefaultPage;
import com.sysco.qe.assignment.utils.DriverSetUpUtil;
import org.openqa.selenium.remote.DesiredCapabilities;


public class BrowseDefault {
    private BrowseDefault(){}

    private static DefaultPage defaultPage=new DefaultPage();
    public static void loadDefaultPage() {
        if (Constants.RUN_LOCALLY) {
            DriverSetUpUtil.setToRunLocally();
            DesiredCapabilities capabilities = null;
            defaultPage.loadingDefaultPage(capabilities, Constants.APP_URL);
        } else {
            defaultPage.loadingDefaultPage(DriverSetUpUtil.setToRunRemotely(Constants.APP_OS), Constants.APP_URL);
        }
    }

    public static void setBirthDay(String day,String month,String year){
        defaultPage.setBirthDay(day,month,year);
    }

    public static String getLblLoginError(){
        return defaultPage.getLblError();
    }

    public static void hitEntetr (){
        defaultPage.hitEnter();
    }

    public static void quitDriver(){
        defaultPage.quitDriver();
    }

    public static boolean successPageNavigation(){
        boolean result=defaultPage.successPageNavigation();
        return result;
    }

    public static String getLblEmptyMsg(){
        return defaultPage.getLblEmptyBirthDate();
    }

}
