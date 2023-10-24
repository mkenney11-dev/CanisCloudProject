package com.sprint1Implementation.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static{

        try{

            //open file from config.prop
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

            //close file in memory
            file.close();
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }

    //this util method will READ from the file (previous methods just open/close file)

    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
