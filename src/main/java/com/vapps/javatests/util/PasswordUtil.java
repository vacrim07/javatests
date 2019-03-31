package com.vapps.javatests.util;

public class PasswordUtil {

    public static SecurityLevel assesPassword(String password){

        if(password.length() < 8) return SecurityLevel.WEAK;

        if(password.matches("[a-zA-z]+")) return SecurityLevel.WEAK;

        if(password.matches("[0-9]+")) return SecurityLevel.WEAK;

        if(password.matches("[a-zA-z0-9]+")) return SecurityLevel.MEDIUM;

        return SecurityLevel.STRONG;
    }
}
