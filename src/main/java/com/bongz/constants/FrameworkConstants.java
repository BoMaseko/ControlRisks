package com.bongz.constants;

import com.bongz.enums.ConfigProperties;
import com.bongz.utilities.PropertyUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class FrameworkConstants {

    private FrameworkConstants(){}

    private static final String RESOURCEPATH = System.getProperty("user.dir") + "/src/main/resources";
    private static final String CONFIGFILEPATH = RESOURCEPATH + "/config/config.properties";
    private static final int EXPLICITWAIT = 30;
    private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir") + "/extent-report-output/";
    private static final String EXCELFOLDERPATH = RESOURCEPATH + "/excel/frameworkData.xlsx";
    private static String extentReportFilePath = "";

    public static String getExtentReportFilePath() {
        if(extentReportFilePath.isEmpty()){
            extentReportFilePath = createReportPath();
        }
        return extentReportFilePath;
    }

    private static String createReportPath() {
        long milliseconds = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM_dd_yyyy");
        Date resultDate = new Date(milliseconds);
        if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")){
            return EXTENTREPORTFOLDERPATH + sdf.format(resultDate) + "_index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH + "/index1.html";
        }
    }

    public static String getConfigFilePath(){
        return CONFIGFILEPATH;
    }

    public static int getExplicitWaitValue(){
        return EXPLICITWAIT;
    }

    public static String getExcelFolderPath(){
        return EXCELFOLDERPATH;
    }
}
