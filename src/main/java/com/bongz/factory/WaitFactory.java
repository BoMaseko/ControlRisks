package com.bongz.factory;

import com.bongz.constants.FrameworkConstants;
import com.bongz.driver.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public final class WaitFactory {

    private WaitFactory(){}

    public static void explicitlyWaitForElementToBeClickable(By by){
        new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitValue()))
                .until(ExpectedConditions.elementToBeClickable(by));

    }

    public static void explicitlyWaitForElementToBePresent(By by){
        new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitValue()))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public static void explicitlyWaitForElementToBeVisible(By by){
        new WebDriverWait(DriverManger.getDriver(), Duration.ofSeconds(FrameworkConstants.getExplicitWaitValue()))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static void none(By by){
        DriverManger.getDriver().findElement(by);
    }
}
