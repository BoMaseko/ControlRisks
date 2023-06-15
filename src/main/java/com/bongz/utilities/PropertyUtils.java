package com.bongz.utilities;

import com.bongz.constants.FrameworkConstants;
import com.bongz.enums.ConfigProperties;
import com.bongz.exceptions.PropertyUtilRuntimeException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public final class PropertyUtils {

    private PropertyUtils(){

    }

    private static Properties property = new Properties();

    static{
        try( FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());){

            property.load(file);
        }
        catch (IOException e){
            e.printStackTrace();
            System.exit(0);
        }

    }

    public static String getValue(ConfigProperties key) {

        if (Objects.isNull(key) || Objects.isNull(property.getProperty(key.name().toLowerCase()))){
            throw new PropertyUtilRuntimeException("Property name " + key + " is not found. Please check config.properties");
        }
        return property.getProperty(key.name().toLowerCase());
    }

}
