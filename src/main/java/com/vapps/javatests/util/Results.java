package com.vapps.javatests.util;

public enum Results {

    FIZZ ("Fizz"),
    BUZZ ("Buzz"),
    FIZZBUZZ ("FizzBuzz"),
    NOT_TRUE ("Not true");

    private String value;

    private Results(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
