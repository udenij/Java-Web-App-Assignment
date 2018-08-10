package com.sysco.qe.assignment.pages;

import com.sysco.qe.assignment.common.Constants;
import com.sysco.qe.assignment.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import com.syscolab.qe.core.ui.SyscoLabUI;
import com.syscolab.qe.core.ui.web.SyscoLabWUI;

import java.io.IOException;

public class DefaultPage {
    protected static SyscoLabUI syscoLabUI;

    private By drpDwnDate=By.xpath("//*[@id=\"age_select_day\"]");
    private By drpDwnMonth=By.xpath("//*[@id=\"age_select_month\"]");
    private By drpDwnYear=By.xpath("//*[@id=\"age_select_year\"]");
    private By btnEnter=By.xpath("//*[@id=\"age_confirm_btn\"]");
    private By lblErrorMsg=By.xpath("//*[@id=\"age_missing_message\"]/span");
    private By linkMyAccount=By.xpath("//*[@id=\"quick-access-list\"]/li[1]/ul/li[2]/ul/li/a");
    private By lblEmptyBirthDateErrorMsg=By.xpath("//*[@id=\"age_missing_message\"]/span");

    public static void loadingDefaultPage(Capabilities capabilities, String url) {
        syscoLabUI = new SyscoLabWUI(capabilities);
        syscoLabUI.navigateTo(url);
        syscoLabUI.driver.manage().window().maximize();
    }

    public void setBirthDay(String date,String month,String year){
        syscoLabUI.sleep(3);
        syscoLabUI.selectFromDropDown(drpDwnDate,date);
        syscoLabUI.sleep(3);
        syscoLabUI.selectFromDropDown(drpDwnMonth,month);
        syscoLabUI.sleep(3);
        syscoLabUI.selectFromDropDown(drpDwnYear,year);

    }
    public void hitEnter(){
        syscoLabUI.sleep(3);
        syscoLabUI.driver.findElement(btnEnter).click();
    }
    public String getLblError() {

        return syscoLabUI.getText(lblErrorMsg);
    }

    public boolean successPageNavigation(){
        if (syscoLabUI.driver.findElement(linkMyAccount).isDisplayed()){
         return true;
        }
        else{
            return false;
        }
    }
    public String getLblEmptyBirthDate(){
        syscoLabUI.sleep(4);
        return syscoLabUI.getText(lblEmptyBirthDateErrorMsg);
    }
    public void quitDriver() {
        if(Constants.BROWSER_TYPE.equals(Constants.BROWSER_IE)){
            try {
                Runtime.getRuntime().exec("taskkill /f /fi \"pid gt 0\" /im iexplore.exe");
            } catch (IOException e) {
                LoggerUtil.logERROR(Constants.IOEXCEPTION_ERROR,e);
            }
        }else{
            syscoLabUI.quit();
        }

    }



}
