package com.vapps.javatests.payments;

public class PaymentProcessor {

    private PaymentGateway paymentGateway;

    public PaymentProcessor(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public Boolean performPayment(Double amount){
        PaymentResponse response = paymentGateway.requestPayment(new PaymentRequest(amount));
        return response.getStatus() == PaymentStatus.OK;
    }
}
