package com.bongz.driver;

import com.bongz.enums.ConfigProperties;
import com.bongz.utilities.PropertyUtils;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.Objects;

public final class Driver {

    private Driver(){

    }

    //public static WebDriver driver;

    public static void initDriver(String browser) {
        if(Objects.isNull(DriverManger.getDriver())){
            if(browser.equalsIgnoreCase("edge")){
                //WebDriverManager.edgedriver().setup(); //no need from 4.6 or higher version
                //driver = new EdgeDriver();
                DriverManger.setDriver(new EdgeDriver());
            } else if (browser.equalsIgnoreCase("chrome")) {
                DriverManger.setDriver(new ChromeDriver());
            }

            DriverManger.getDriver().manage().window().maximize();
            DriverManger.getDriver(). get(PropertyUtils.getValue(ConfigProperties.URL));
        }
    }

    public static void quitDriver(){
        if(Objects.nonNull(DriverManger.getDriver())){
            DriverManger.getDriver().quit();
            DriverManger.unload();
        }
    }
}
