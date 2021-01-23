package com.isgoto.synchronous.util;

public class StringUtil {
    public static Boolean isBlank(String str){
        return str == null || str.equals("");
    }

    public static Boolean isNotBlank(String str){
        return !isBlank(str);
    }
}
