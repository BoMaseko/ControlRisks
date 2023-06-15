package com.bongz.pages;

import com.bongz.driver.DriverManger;
import com.bongz.enums.WaitStrategy;
import com.bongz.factory.WaitFactory;
import com.bongz.reports.ExtentLogger;
import org.openqa.selenium.By;

public class BasePage {

    protected void click(By by, WaitStrategy waitStrategy, String elementName) throws Exception {

        if(waitStrategy == WaitStrategy.CLICKABLE){
            WaitFactory.explicitlyWaitForElementToBeClickable(by);
        }
        else if(waitStrategy == WaitStrategy.PRESENCE){
            WaitFactory.explicitlyWaitForElementToBePresent(by);
        }
        DriverManger.getDriver().findElement(by).click();
        ExtentLogger.pass(elementName + " is clicked", true);
    }

    protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName){
        if(waitStrategy == WaitStrategy.CLICKABLE){
            WaitFactory.explicitlyWaitForElementToBeClickable(by);
        }
        else if(waitStrategy == WaitStrategy.PRESENCE){
            WaitFactory.explicitlyWaitForElementToBePresent(by);
        }

        DriverManger.getDriver().findElement(by).sendKeys(value);
        ExtentLogger.pass(value + " is entered successfully in " + elementName);
    }

    protected String getPageTitle(){
        return DriverManger.getDriver().getTitle();
    }


}
