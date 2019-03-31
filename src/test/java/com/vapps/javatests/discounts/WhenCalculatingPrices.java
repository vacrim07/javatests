package com.vapps.javatests.discounts;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class WhenCalculatingPrices {

    PriceCalculator calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new PriceCalculator();
    }

    @Test
    public void should_be_zero_when_there_are_not_itmes() {

        assertThat(calculator.getTotal(), is(0.0));
    }

    @Test
    public void should_be_the_total_item_prices() {

        calculator.addPrice(10.2);
        calculator.addPrice(5.3);

        assertThat(calculator.getTotal(), is(15.5));
    }

    @Test
    public void should_apply_a_50_percent_disscount() {

        calculator.addPrice(10.0);
        calculator.addPrice(20.0);

        calculator.setDiscount(50.0);

        assertThat(calculator.getTotal(), is(15.0));
    }

    @Test
    public void should_apply_a_10_percent_disscount() {

        calculator.addPrice(100.0);

        calculator.setDiscount(10.0);

        assertThat(calculator.getTotal(), is(90.0));
    }
}