package com.ps;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userIn;

        do {
            System.out.println("Welcome to the store. Please select an option: ");
            System.out.println("\t1) Display Products");
            System.out.println("\t2) Display Cart");
            System.out.println("\t3) Exit");
            userIn = scanner.nextInt();

            switch (userIn) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    break;
                default:
                    System.out.println("Command not found");
            }

        } while(userIn != 3);
    }
    //method to display products
    private static void displayProducts(ArrayList<Product> products){
        System.out.println("Products: ");
        for (int counter1 = 0; counter1 < products.size(); counter1++){
            Product product = products.get(counter1);
            System.out.println(product.getSku() + ". " + product.getProductName() + ", $" + product.getPrice() +" " + product.getDepartment());
        }
    }
    //method to display items in cart
    private static void displayCart(ArrayList<Product> itemsInCart){
        if(itemsInCart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (int counter2 = 0; counter2 < itemsInCart.size(); counter2++){
                Product product = itemsInCart.get(counter2);
                System.out.println(product.getSku() + ". " + product.getProductName() + ", $" + product.getPrice() +" " + product.getDepartment());
            }
        }

    }
}