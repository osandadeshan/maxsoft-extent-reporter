package com.maxsoft.extentreport;

import org.openqa.selenium.WebDriver;

/**
 * Project Name    : maxsoft-extent-reporter
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/21/2020
 * Time            : 12:02 PM
 * Description     : This is the driver holder class that used to set the WebDriver and get it
 **/

public class DriverHolder {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver driver) {
        DriverHolder.driver.set(driver);
    }
}
