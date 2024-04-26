package com.ps;

import java.util.ArrayList;

public class ShoppingCart {
    //ArrayList containing items in cart
    private static ArrayList<Product> itemsInCart;
    //Constructor of Shopping Cart
    public ShoppingCart(){
        itemsInCart = new ArrayList<>();
    }
    //method to add a product to cart
    public void addItem(Product product){
        itemsInCart.add(product);
    }
    //method to read list of items in cart
    public ArrayList<Product> getItemsInCart(){
        return itemsInCart;
    }
}
