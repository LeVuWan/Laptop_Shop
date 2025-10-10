package com.windy.domains;

import java.io.Serializable;

public class OrderProductId implements Serializable {
    private Long productId;
    private Long orderId;

    public OrderProductId() {
    }

    public OrderProductId(Long productId, Long orderId) {
        this.productId = productId;
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

}