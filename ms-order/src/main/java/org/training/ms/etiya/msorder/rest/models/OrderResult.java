package org.training.ms.etiya.msorder.rest.models;

public class OrderResult {

    private Long orderId;
    private String desc;

    public Long getOrderId() {
        return orderId;
    }

    public OrderResult setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public OrderResult setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
