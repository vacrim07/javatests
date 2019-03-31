package com.vapps.javatests.payments;

public class PaymentRequest {

    private Double amount;

    public PaymentRequest(Double amount) {
        this.amount = amount;
    }

    public Double getAmount() {
        return amount;
    }
}
