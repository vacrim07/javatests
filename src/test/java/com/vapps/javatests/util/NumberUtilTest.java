package com.vapps.javatests.util;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class NumberUtilTest {

    List<Integer> numbers;

    @Before
    public void setUp() throws Exception {
        numbers = new ArrayList<>();
    }

    @Test
    public void should_return_fizz() {

        NumberUtil numberToEvaluate = new NumberUtil(9);
        numbers.add(3);

        String result = numberToEvaluate.isDivisibleBy(numbers);

        assertEquals(Results.FIZZ.getValue(), result);
    }

    @Test
    public void should_return_buzz() {

        NumberUtil numberToEvaluate = new NumberUtil(10);
        numbers.add(5);

        String result = numberToEvaluate.isDivisibleBy(numbers);

        assertEquals(Results.BUZZ.getValue(), result);
    }

    @Test
    public void should_return_fizzbuzz() {

        NumberUtil numberToEvaluate = new NumberUtil(15);
        numbers.add(3);
        numbers.add(5);

        String result = numberToEvaluate.isDivisibleBy(numbers);

        assertEquals(Results.FIZZBUZZ.getValue(), result);
    }


}