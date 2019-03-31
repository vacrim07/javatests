package com.vapps.javatests.util;

public class StringUtil {

    public static String repeat(String string, Integer times){

        if(times < 0) throw new IllegalArgumentException("Negative times are not allowed");

        String result = "";
        for (int i = 0; i < times; i++) result += string;
        return result;
    }

    public static Boolean isEmpty(String string){

        if (string == null) return true;

        return string.trim().equals("");

    }
}
