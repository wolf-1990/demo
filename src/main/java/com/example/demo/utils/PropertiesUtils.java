package com.example.demo.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtils {
    public static String getPropertyByName(String resource,String key){
        String result = null;

        Properties properties = new Properties();
        //读取配置文件
        InputStream is = PropertiesUtils.class.getClassLoader().getResourceAsStream(resource);
        try {
            properties.load(is);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        result = (String)properties.get(key);
        return result;
    }
}
