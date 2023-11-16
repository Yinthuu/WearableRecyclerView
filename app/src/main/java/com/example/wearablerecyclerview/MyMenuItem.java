package com.example.wearablerecyclerview;

public class MyMenuItem {


    private String text;
    private int image;
    public MyMenuItem(String text, int image) {
        this.text = text;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public int getImage() {
        return image;
    }
}
