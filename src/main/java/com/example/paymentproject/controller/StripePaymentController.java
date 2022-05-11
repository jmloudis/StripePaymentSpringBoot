package com.example.paymentproject.controller;

import com.example.paymentproject.model.Payment;
import com.example.paymentproject.service.CreatePayment;
import com.example.paymentproject.service.CreatePaymentResponse;
import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StripePaymentController {

    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPaymentIntent(@RequestBody Payment payment) throws StripeException {

        PaymentIntentCreateParams params = new PaymentIntentCreateParams.Builder()
                        .setAmount(15 * 100L) //createPayment... dollar amount * cents ... 15 * 100 cents = 15$
                        .setCurrency("usd")
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
