package com.example.recyclerview.model;

public class CategoryItem {
    Integer imageId;
    Integer imageUrl;

    public CategoryItem(Integer imageId, Integer imageUrl) {
        this.imageId = imageId;
        this.imageUrl = imageUrl;
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }
}
