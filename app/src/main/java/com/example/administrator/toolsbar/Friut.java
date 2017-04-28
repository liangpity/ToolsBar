package com.example.administrator.toolsbar;

/**
 * Created by lb on 2017-02-11.
 */

public class Friut {

    private String FriutName;
    private int imageId;

    public Friut(String name ,int imageId){
        this.FriutName = name;
        this.imageId = imageId;
    }

    public String getFriutName() {
        return FriutName;
    }

    public int getImageId() {
        return imageId;
    }
}
