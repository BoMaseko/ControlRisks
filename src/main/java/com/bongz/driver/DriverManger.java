package com.bongz.driver;

import org.openqa.selenium.WebDriver;

public final class DriverManger {

    private DriverManger(){

    }

    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return dr.get();
    }

    public static void setDriver(WebDriver driver_ref){
        dr.set(driver_ref);
    }

    public static void unload(){
        dr.remove();
    }
}
