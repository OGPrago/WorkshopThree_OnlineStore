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
    //method to read list of items in cart
    public ArrayList<Product> getItemsInCart(){
        return itemsInCart;
    }
}
// Steps to add items to a cart
//1.Go to store website
//2. Select item
//3. Click to add to cart
//4.Click go to cart
//5.Select go to check out, remove item, edit quantity, compare with other items, share




public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userIn;

        do {
            System.out.println("Please select an item ");
            System.out.println("\t1) Add to Cart");
            System.out.println("\t2) Display Cart");
            System.out.println("\t3) Edit quantity of items");
            System.out.println("\t4)  Remove items");
            System.out.println("\t5) Find similar items");
