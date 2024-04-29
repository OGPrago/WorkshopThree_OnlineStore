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
                    System.out.println("Here are all our products.");
                    displayProducts();

                    int productsCommand;

                    do {
                    System.out.println("\t1) Search");
                    System.out.println("\t2) Add product to cart");
                    System.out.println("\t3) Back to home screen");
                    productsCommand = scanner.nextInt();

                    switch (productsCommand) {
                        case 1:
                            System.out.println("Enter SKU of item you want to search: ");
                            int searchCommand = scanner.nextInt();

                            if (searchCommand == 1) {
                                System.out.println();
                            }
                            else if (searchCommand == 2) {
                                System.out.println();
                            }
                            else if (searchCommand == 3) {
                                System.out.println();
                            }
                            else if (searchCommand == 4) {
                                System.out.println();
                            }
                            else if (searchCommand == 5) {
                                System.out.println();
                            }
                            else if (searchCommand == 6) {
                                System.out.println();
                            }
                            else if (searchCommand == 7) {
                                System.out.println();
                            }
                            else if (searchCommand == 8) {
                                System.out.println();
                            }
                            else if (searchCommand == 9) {
                                System.out.println();
                            }
                            else if (searchCommand == 10) {
                                System.out.println();
                            }
                            else if (searchCommand == 11) {
                                System.out.println();
                            }
                            else if (searchCommand == 12) {
                                System.out.println();
                            }
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("Command not found.");
                    }

                    } while(productsCommand != 3);
                    break;
                case 2:
                    System.out.println("Your cart");


                    int cartCommand;

                    do {
                        System.out.println("\t1) Check out");
                        System.out.println("\t2) Remove Product");
                        System.out.println("\t3) Back to home screen");
                        cartCommand = scanner.nextInt();

                        switch (cartCommand){
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Command not found.");
                        }
                    } while(cartCommand != 3);
                    break;
                case 3:
                    System.out.println("Thank you for shopping.");
                    break;
                default:
                    System.out.println("Command not found.");
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