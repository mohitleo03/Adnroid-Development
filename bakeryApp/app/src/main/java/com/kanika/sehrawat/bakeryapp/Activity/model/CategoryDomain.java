package com.kanika.sehrawat.bakeryapp.Activity.model;

public class CategoryDomain {
    private String title;
    private Integer pic;

    public CategoryDomain(String title, Integer pic) {
        this.title = title;
        this.pic = pic;
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
}
