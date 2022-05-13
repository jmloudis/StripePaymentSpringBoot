package com.example.paymentproject.controller;

import com.example.paymentproject.model.Payment;
import com.example.paymentproject.service.CreatePaymentResponse;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class StripePaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody @Valid Payment payment) throws StripeException {

        PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder()
                        .setCurrency("usd")
                        .setAmount(payment.getAmount() * 100L) //createPayment... dollar amount * cents ... 15 * 100 cents = 15$
                        .setAutomaticPaymentMethods(
                        PaymentIntentCreateParams.AutomaticPaymentMethods
                                .builder()
                                .setEnabled(true)
                                .build()
                        )
                        .build();

        // Create a PaymentIntent with the order amount and currency
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        return new CreatePaymentResponse(paymentIntent.getClientSecret());

    }
}
