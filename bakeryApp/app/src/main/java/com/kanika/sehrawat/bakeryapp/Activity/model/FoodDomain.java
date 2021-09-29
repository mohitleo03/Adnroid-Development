package com.kanika.sehrawat.bakeryapp.Activity.model;

import java.io.Serializable;

public class FoodDomain implements Serializable {
    private String title;
    private Integer pic;
    private String description;
    private Double price;
    private int quantity;
    private String category;

    public FoodDomain(String title, Integer pic, String description, Double price, String category) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.category=category;
    }

    public FoodDomain(String title, Integer pic, String description, Double price, int quantity, String category) {
        this.title = title;
        this.pic = pic;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category=category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPic() {
        return pic;
    }

    public void setPic(Integer pic) {
        this.pic = pic;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

