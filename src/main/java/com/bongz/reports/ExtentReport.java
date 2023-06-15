package com.bongz.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.bongz.constants.FrameworkConstants;
import com.bongz.enums.CategoryType;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public final class ExtentReport {

    private ExtentReport(){}

    private static ExtentReports extent;

    public static void initReports() {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.DARK);
            spark.config().setDocumentTitle("Bongz Automation Report");
            spark.config().setReportName("Bongz Automation");
        }
    }

    public static void createTest(String testCaseName){
        ExtentTest test = extent.createTest(testCaseName);
        ExtentManager.setExtentTest(test);
    }

    public static void closeReports() {
        if(Objects.nonNull(extent)){
            extent.flush();
        }
        ExtentManager.unload();
        try {
            Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addAuthors(String[] authors){
        for (String temp : authors){
            ExtentManager.getExtentTest().assignAuthor(authors);
        }
    }

    public static void addCategories(CategoryType[] categories){
        for(CategoryType temp : categories){
            ExtentManager.getExtentTest().assignCategory(String.valueOf(temp));
        }
    }
}
