package com.bongz.reports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {

    private ExtentManager(){}

    private static final ThreadLocal<ExtentTest> extTest = new ThreadLocal<>();

    static ExtentTest getExtentTest(){ //default --> it can only be accessed within a package
        return extTest.get();
    }

    static void setExtentTest(ExtentTest test){
        extTest.set(test);
    }

    static void unload(){
        extTest.remove();
    }
}
