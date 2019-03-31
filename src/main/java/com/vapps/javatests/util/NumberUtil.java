package com.vapps.javatests.util;

import java.util.List;

public class NumberUtil {

    private Integer number;

    public NumberUtil(Integer number) {
        this.number = number;
    }

    public String isDivisibleBy(List<Integer> numbers){

        String result = "";

        for (Integer aNumber:
             numbers) {
            switch (aNumber){
                case 3:
                    result += number % 3 == 0 ? Results.FIZZ.getValue() : "";
                    break;
                case 5:
                    result += number % 5 == 0 ? Results.BUZZ.getValue() : "";
            }
        }
        return result;
    }
}
