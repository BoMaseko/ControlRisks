package com.bongz.utilities;

import com.bongz.driver.DriverManger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenShotUtils {

    private ScreenShotUtils(){}

    public static String getBase64Image(){
        return ((TakesScreenshot) DriverManger.getDriver()).getScreenshotAs(OutputType.BASE64);
    }

}
