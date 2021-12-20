package com.boorsoft.Models;

public class GoodsModel {
    private String title;
    private String amount;
    private String price;
    private String orderDate;
    private String deliveryDate;

    public GoodsModel(String title, String amount, String price, String orderDate, String deliveryDate) {
        this.title = title;
        this.amount = amount;
        this.price = price;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
    }

    public GoodsModel() {

    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
