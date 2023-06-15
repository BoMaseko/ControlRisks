package com.bongz.utilities;

import com.bongz.constants.FrameworkConstants;
import com.bongz.exceptions.ExcelPathNotFoundException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List getTestData(String sheetName) {


        List<Map<String, String>> list = null;
        try (FileInputStream fs =  new FileInputStream(FrameworkConstants.getExcelFolderPath())){
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetName);

            int lastRowNum = sheet.getLastRowNum();
            int lastColumnNum = sheet.getRow(0).getLastCellNum();

            Map<String, String> map = null;
            list = new ArrayList<>();

            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColumnNum; j++) {
                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    map.put(key, value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e) {
            throw new ExcelPathNotFoundException("Cannot find the excel file path");
        } catch (IOException e) {
            throw new ExcelPathNotFoundException("Excel run time exception occurred");
        }


        return list;
    }
}
