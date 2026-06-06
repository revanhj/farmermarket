package com.farmermarket;
import java.time.LocalDate;

public class Order {
    
    private String orderId;
    private String customerName;
    private LocalDate orderDate;
    private double totalAmount;
    private String status;
    private String shippingAddress;

    // Constructor
    public Order(String orderId, String customerName, LocalDate orderDate,
                 double totalAmount, String status, String shippingAddress) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
        this.shippingAddress = shippingAddress;
    }

    // Getters and Setters

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    // toString for easy printing
    @Override
    public String toString() {
        return "Order{" +
               "orderId='" + orderId + '\'' +
               ", customerName='" + customerName + '\'' +
               ", orderDate=" + orderDate +
               ", totalAmount=" + totalAmount +
               ", status='" + status + '\'' +
               ", shippingAddress='" + shippingAddress + '\'' +
               '}';
    }
}
