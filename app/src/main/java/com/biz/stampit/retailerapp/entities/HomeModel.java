package com.biz.stampit.retailerapp.entities;

/**
 * Created by Stampit-PC1 on 5/31/2017.
 */

public class HomeModel {
    private int imageId;
    private String title;

    public HomeModel(int imageId, String title) {
        this.imageId = imageId;
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
