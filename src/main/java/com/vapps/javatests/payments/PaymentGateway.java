package com.vapps.javatests.payments;

public interface PaymentGateway {

    PaymentResponse requestPayment(PaymentRequest request);
}
