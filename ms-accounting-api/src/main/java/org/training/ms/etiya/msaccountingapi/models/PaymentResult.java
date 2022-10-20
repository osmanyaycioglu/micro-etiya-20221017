package org.training.ms.etiya.msaccountingapi.models;

import java.math.BigDecimal;

public class PaymentResult {
    private String desc;
    private BigDecimal amount;
    private Long customerId;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}
