package com.vapps.javatests.util;

import org.junit.Test;

import static com.vapps.javatests.util.StringUtil.isEmpty;
import static com.vapps.javatests.util.StringUtil.repeat;
import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void should_return_the_text_three_times (){
        assertEquals("hellohellohello", repeat("hello",3));
    }

    @Test
    public void should_return_the_text_once (){
        assertEquals("hello", repeat("hello",1));
    }

    @Test
    public void should_return_empty_text (){
        assertEquals("", repeat("hello",0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_return_illegal_argument_exception (){
        repeat("hello",-1);
    }

    @Test
    public void should_return_empty_when_only_has_double_quotes() {
        assertTrue(isEmpty(""));
    }

    @Test
    public void should_return_empty_when_only_has_spaces() {
        assertTrue(isEmpty("  "));
    }

    @Test
    public void should_return_empty_when_is_null() {
        assertTrue(isEmpty(null));
    }

    @Test
    public void should_return_not_empty_when_is_a_regular_string() {
        assertFalse(isEmpty("qwerty"));
    }
}