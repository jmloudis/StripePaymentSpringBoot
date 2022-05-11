package com.example.paymentproject;

import com.stripe.Stripe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class PaymentProjectApplication {

    @Value("${stripe.api.key}")
    private String stripeApiKey;

    //@PostConstruct is an annotation used on a method that needs to be executed
    // after dependency injection is done to perform any initialization.
    // -CreatePaymentResponse Constructor
    @PostConstruct
    public void setup() {
        Stripe.apiKey = stripeApiKey;
    }

    public static void main(String[] args) {
        SpringApplication.run(PaymentProjectApplication.class, args);
    }

}
