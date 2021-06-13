package com.paradox.foodDelivery.models;

import com.paradox.foodDelivery.models.enums.PaymentStatus;
import com.paradox.foodDelivery.models.enums.PaymentType;

import java.util.Map;

public class Payment {
    private final String id;
    private final String orderId;
    private final Map<PaymentType, Double> amountPaid;
    private PaymentStatus status;

    public Payment(String id, String orderId, Map<PaymentType, Double> amountPaid) {
        this.id = id;
        this.orderId = orderId;
        this.amountPaid = amountPaid;
        this.status = PaymentStatus.PENDING;
    }

    public void markPaymentDeclined() {
        this.status = PaymentStatus.DECLINED;
    }

    public void markPaymentApproved() {
        this.status = PaymentStatus.APPROVED;
    }

    public void markPaymentTimeout() {
        this.status = PaymentStatus.TIMEOUT;
    }

    public String getId() {
        return id;
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<PaymentType, Double> getAmountPaid() {
        return amountPaid;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", orderId='" + orderId + '\'' +
                ", amountPaid=" + amountPaid +
                ", status=" + status +
                '}';
    }
}
