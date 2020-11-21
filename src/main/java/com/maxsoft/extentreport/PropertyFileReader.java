package com.maxsoft.extentreport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Project Name    : maxsoft-extent-reporter
 * Developer       : Osanda Deshan
 * Version         : 1.0.0
 * Date            : 11/21/2020
 * Time            : 11:31 AM
 * Description     : This is the property file reader class that is used to read the properties inside './src/test/resources/config.properties'
 **/

public class PropertyFileReader {

    public static String getProperty(String propertyName) {
        String propertyValue = null;

        try (InputStream input = new FileInputStream("./src/test/resources/config.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            propertyValue = prop.getProperty(propertyName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }
}
