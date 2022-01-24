package com.example.test.View;

public class RecyclerBean  {
    private int img;
    private String name;
    private String type;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RecyclerBean(int img, String name, String type) {
        this.img = img;
        this.name = name;
        this.type = type;
    }
}
