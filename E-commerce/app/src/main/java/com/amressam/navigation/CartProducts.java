package com.amressam.navigation;

public class CartProducts {
    int image;
    String name;
    String price;
    int quantity;
    String purchased;
    String username;


    public CartProducts(int image, String name, String price, int quantity,String purchased,String username) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.purchased=purchased;
        this.username=username;
    }


    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPurchased() {
        return purchased;
    }

    public void setPurchased(String purchased) {
        this.purchased = purchased;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
