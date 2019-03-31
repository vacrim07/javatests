package com.vapps.javatests.util;

public enum SecurityLevel {
    MEDIUM ("Medium"),
    STRONG ("Strong"),
    WEAK ("Weak");

    private final String value;

    public String getValue() {
        return value;
    }

    private SecurityLevel(String value) {
        this.value = value;
    }
}
