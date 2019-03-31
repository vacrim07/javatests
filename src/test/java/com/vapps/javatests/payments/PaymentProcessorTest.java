package com.vapps.javatests.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {

    PaymentGateway paymentGateway;
    PaymentProcessor paymentProcessor;

    @Before
    public void setUp() throws Exception {
        paymentGateway = Mockito.mock(PaymentGateway.class);
        paymentProcessor = new PaymentProcessor(paymentGateway);
    }

    @Test
    public void should_be_a_successful_payment() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentStatus.OK));

        Boolean transactionResult = paymentProcessor.performPayment(1000.00);

        assertTrue(transactionResult);
    }

    @Test
    public void should_be_a_unsuccessful_payment() {

        Mockito.when(paymentGateway.requestPayment(Mockito.any()))
                .thenReturn(new PaymentResponse(PaymentStatus.ERROR));

        Boolean transactionResult = paymentProcessor.performPayment(1000.00);

        assertFalse(transactionResult);
    }
}