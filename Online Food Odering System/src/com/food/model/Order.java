package com.food.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private long orderId;
    private static long totalOrders=1;
    private List<Items> cart;
    private String deliveryAddress;
    private long contactDetails;
    private OrderStatus orderStatus;
    private String paymentDetails;
    private double totalBill;
    private static List<Order> allOrder;

    public Order(List<Items> cart, String deliveryAddress, String paymentDetails, double totalBill) {
        if(allOrder==null){
            allOrder=new ArrayList<>();
        }
        this.orderId = totalOrders;
        this.cart = cart;
        this.deliveryAddress = deliveryAddress;
        this.orderStatus = OrderStatus.CONFIRMED;
        this.paymentDetails = paymentDetails;
        this.totalBill = totalBill;
        totalOrders++;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", contactDetails=" + contactDetails +
                ", orderStatus=" + orderStatus +
                ", paymentDetails='" + paymentDetails + '\'' +
                ", totalBill=" + totalBill +
                '}';
    }

    public static void printOrderInfo(long orderId){
        Order ord = getOrderByOrderId(orderId);
        if(ord!=null){
            System.out.println(ord);
        }
        else{
            System.out.println("No Order found with the ID:"+orderId);
        }
    }
    public static void addOrder(Order order){
        allOrder.add(order);
        printOrderInfo(order.getOrderId());
    }
    public long getOrderId() {
        return orderId;
    }
    public static Order getOrderByOrderId(long orderId){
        for(var order:allOrder){
            if(order.getOrderId()==orderId){
                return order;
            }
        }
        return null;
    }
    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public static long getTotalOrders() {
        return totalOrders;
    }

    public static void setTotalOrders(long totalOrders) {
        Order.totalOrders = totalOrders;
    }

    public List<Items> getCart() {
        return cart;
    }

    public void setCart(List<Items> cart) {
        this.cart = cart;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(String paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    public double getTotalBill() {
        return totalBill;
    }

    public void setTotalBill(double totalBill) {
        this.totalBill = totalBill;
    }
}
