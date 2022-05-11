package com.example.paymentproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Payment {

    @NotNull
    @Min(4)
    private Integer amount;

    @NotNull
    private String featureRequest;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFeatureRequest() {
        return featureRequest;
    }

    public void setFeatureRequest(String featureRequest) {
        this.featureRequest = featureRequest;
    }
}
