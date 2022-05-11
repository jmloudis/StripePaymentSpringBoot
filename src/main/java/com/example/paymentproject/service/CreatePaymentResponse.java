package com.example.paymentproject.service;

public class CreatePaymentResponse {
    private String clientSecret;

    //dependency injection
    public CreatePaymentResponse(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }


}
