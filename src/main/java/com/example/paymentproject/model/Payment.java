package com.example.paymentproject.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Payment {

    @NotNull
    private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

}
