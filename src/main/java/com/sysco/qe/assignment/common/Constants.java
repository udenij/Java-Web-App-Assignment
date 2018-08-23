package com.sysco.qe.assignment.common;

public class Constants {
    private Constants(){}

    public static final boolean RUN_LOCALLY = Boolean.parseBoolean(System.getProperty("run.locally", "true"));
    public static final String ARCH = System.getProperty("os.arch");
    public static final String BROWSER_TYPE = "chrome";

    public static final String BROWSER_IE = "internet explorer";
    public static final String BROWSER_FIREFOX = "firefox";

    public static final String APP_URL = System.getProperty("app.url", "https://www.bundabergrum.com.au/");
    public static final String APP_OS = System.getProperty("app.os", "WIN10");


    public static final String SEPERATOR =System.getProperty("file.separator");
    public static final String PATH_DATA_DIRECTORY=System.getProperty("user.dir")+SEPERATOR+"src"+SEPERATOR+"main"+SEPERATOR+"resources"+SEPERATOR+"Data"+SEPERATOR;

    public static final String PROJECT_NAME = SUTAPProperties.getProperty("test.project");
    public static final String TEST_ENV = SUTAPProperties.getProperty("test.env");
    public static final String TEST_RELEASE = SUTAPProperties.getProperty("test.release");
    public static final boolean UPDATE_Q_CENTER = Boolean.parseBoolean(SUTAPProperties.getProperty("update.qcenter"));

    public static final String IOEXCEPTION_ERROR="IO Exception";
    public static final String FILE_NOT_FOUND_ERROR="File not found";

    public static final String ERROR_MSG_ACESS_DENIED="Sorry, your age or location does not permit you to enter at this time.";
    public static final String ERROR_MSG_INVALID_PWRD="Please enter 6 or more characters. Leading or trailing spaces will be ignored.";
    public static final String ERROR_MSG_INVALID_EMAIL="Please enter a valid email address. For example johndoe@domain.com.";
    public static final String ERROR_MSG_INVALID_USER="Invalid login or password.";
    public static final String ERROR_MSG_REQUIRED_FIELD="This is a required field.";
    public static final String VALID_USER_MSG="HELLO, WILLIAM JACOB!";
    public static final String ERROR_MSG_EMPTY_BITHDATE="Please enter your date of birth";
    public static final String ERROR_MSG_EMPTY_CART="You have no items in your shopping cart.";
    public static final String DELIVERY_OPTION_MSG="I am aware that parcels will not be left unattended - must be signed for by a person over the age of 18. ";
    public static final String ERROR_INAVLID_CC_NUMBER="Please enter a valid credit card number.";
}
