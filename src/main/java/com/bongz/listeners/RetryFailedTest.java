package com.bongz.listeners;

import com.bongz.enums.ConfigProperties;
import com.bongz.utilities.PropertyUtils;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTest implements IRetryAnalyzer {

    private int count = 0;
    private int retry = 1;
    boolean value = false;

    @Override
    public boolean retry(ITestResult iTestResult) {

        try {
            if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("yes")){
                value = count<retry;
                count++;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return value;
    }
}
