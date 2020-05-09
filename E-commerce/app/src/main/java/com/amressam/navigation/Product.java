package com.amressam.navigation;

import java.io.Serializable;

public class Product implements Serializable {
    int image;
    String name;
    String price;


    public Product(int image, String name, String price) {
        this.image = image;
        this.name = name;
        this.price = price;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
