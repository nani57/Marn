package com.marn.marn.model;

import java.io.Serializable;

public class ItemsDetails implements Serializable {
    private String title;
    int imageSource;
    int selectedItems;
    Double price;

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    int totalPrice;

    public ItemsDetails() {
    }

    public int getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(int selectedItems) {
        this.selectedItems = selectedItems;
    }

    public ItemsDetails(int imageSource, String title, Double price) {
        this.imageSource = imageSource;
        this.title = title;
        this.price = price;
    }

    public int getImageSource() {
        return imageSource;
    }

    public void setImageSource(int imageSource) {
        this.imageSource = imageSource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
