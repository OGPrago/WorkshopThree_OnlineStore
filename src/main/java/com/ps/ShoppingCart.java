package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

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
    //method to remove a product to cart
    public void removeItem(Product product){
        itemsInCart.remove(product);
    }
    //method to read list of items in cart
    public static ArrayList<Product> getItemsInCart(){
        return itemsInCart;
    }
}



