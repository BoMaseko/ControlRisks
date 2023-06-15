package com.bongz.utilities;

public final class DynamicXpathUtils {

    private DynamicXpathUtils(){}

    public static String getXpath(String xpath, String value){
        return xpath.replace("%replaceable%", value);
        //return xpath.replace(xpath, value); //a[text()='%s']
    }
}
