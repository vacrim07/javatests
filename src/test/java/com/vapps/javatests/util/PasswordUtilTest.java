package com.vapps.javatests.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void should_return_weak_when_it_has_less_than_8_characters() {
        assertEquals(SecurityLevel.WEAK, PasswordUtil.assesPassword("12ABCd!"));
    }

    @Test
    public void should_return_weak_when_it_has_only_letters() {
        assertEquals(SecurityLevel.WEAK, PasswordUtil.assesPassword("qwertyasdf"));
    }

    @Test
    public void should_return_weak_when_it_has_only_numbers() {
        assertEquals(SecurityLevel.WEAK, PasswordUtil.assesPassword("123456789"));
    }

    @Test
    public void should_return_medium_when_it_has_numbers_and_letters() {
        assertEquals(SecurityLevel.MEDIUM, PasswordUtil.assesPassword("qwerty1234"));
    }

    @Test
    public void should_return_medium_when_it_has_numbers_letters_and_symbols() {
        assertEquals(SecurityLevel.STRONG, PasswordUtil.assesPassword("qwerty1234!"));
    }
}