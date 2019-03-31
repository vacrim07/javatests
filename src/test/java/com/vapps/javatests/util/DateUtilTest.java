package com.vapps.javatests.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DateUtilTest {

    @Test
    public void should_return_true_when_is_divisible_by_400() {

        assertThat(DateUtil.isLeapYear(1600), is(true));
        assertThat(DateUtil.isLeapYear(2000), is(true));
        assertThat(DateUtil.isLeapYear(2100), is(false));
    }

    @Test
    public void should_return_true_when_is_divisible_by_4_but_not_by_100() {

        assertThat(DateUtil.isLeapYear(1996), is(true));
        assertThat(DateUtil.isLeapYear(2004), is(true));
        assertThat(DateUtil.isLeapYear(2020), is(true));
    }

    @Test
    public void should_return_false_to_other_cases() {

        assertThat(DateUtil.isLeapYear(1700), is(false));
        assertThat(DateUtil.isLeapYear(1991), is(false));
        assertThat(DateUtil.isLeapYear(2001), is(false));
        assertThat(DateUtil.isLeapYear(2018), is(false));
    }
}