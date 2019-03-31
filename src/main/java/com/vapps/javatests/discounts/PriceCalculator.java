package com.vapps.javatests.discounts;

public class PriceCalculator {

    private Double totalPrice = 0.0;
    private Double disccount = 0.0;

    public Double getTotal() {

        return totalPrice - (totalPrice * disccount);
    }

    public void addPrice(Double price) {
        totalPrice += price;
    }

    public Double setDiscount(Double disscount) {
        return this.disccount = disscount / 100;
    }
}
