package com.bongz.utilities;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

    private DataProviderUtils(){}

    private static List<Map<String, String>> list = new ArrayList<>();


    @DataProvider(parallel = false)
    public static Object[] getData(Method m){

        if(list.isEmpty()){
            list = ExcelUtils.getTestData("DATA");
        }

        List<Map<String, String>> small_list = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            if(list.get(i).get("testname").equalsIgnoreCase(m.getName())
                && list.get(i).get("execute").equalsIgnoreCase("yes")){
                    small_list.add(list.get(i));
            }


        }

        //list.removeAll(small_list);
        return small_list.toArray();
    }

}
