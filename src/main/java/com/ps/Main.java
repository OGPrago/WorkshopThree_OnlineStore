package com.ps;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store();
        ShoppingCart shoppingCart = new ShoppingCart();
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
                    displayProducts(store.getProducts());
                    int productsCommand;

                    do {
                        System.out.println("\t1) Search");
                        System.out.println("\t2) Add product to cart");


                        System.out.println("\t3) Back to home screen");

                        productsCommand = scanner.nextInt();

                        switch (productsCommand) {
                            case 1:
                                int searchCommand;
                                do {
                                    System.out.println("Search by: ");
                                    System.out.println("\t1) Product Name");
                                    System.out.println("\t2) Price Range");
                                    System.out.println("\t3) Department");
                                    System.out.println("\t4) Back to Cart");
                                    searchCommand = scanner.nextInt();

                                    switch (searchCommand) {
                                        case 1:
                                            System.out.println("Enter product name to search:");
                                            String productName = scanner.next();
                                            displayProducts(store.searchByName(productName));
                                            break;
                                        case 2:
                                            System.out.println("Enter minimum price:");
                                            float minPrice = scanner.nextFloat();
                                            System.out.println("Enter maximum price:");
                                            float maxPrice = scanner.nextFloat();
                                            displayProducts(store.searchByPrice(minPrice, maxPrice));
                                            break;
                                        case 3:
                                            System.out.println("Enter department to search:");
                                            scanner.nextLine();
                                            String department = scanner.nextLine();
                                            displayProducts(store.searchByDepartment(department));
                                            break;
                                        case 4:
                                            break;
                                        default:
                                            System.out.println("Invalid option.");

                                    }
                                }while (searchCommand !=4);

                                break;
                            case 2:
                                System.out.println("Enter the SKU of the product to add to cart:");
                                int skuToAdd = scanner.nextInt();
                                Product productToAdd = store.findProductBySku(skuToAdd);
                                if(productToAdd != null){
                                    shoppingCart.addItem(productToAdd);
                                    System.out.println(productToAdd.getProductName()+ " added to cart.");
                                } else {
                                    System.out.println("Product not Found.");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Command not found.");
                        }

                    } while (productsCommand != 3);
                    break;
                case 2:
                    System.out.println("Your cart");
                    displayCart(ShoppingCart.getItemsInCart());




                    int cartCommand;

                    do {
                        System.out.println("\t1) Check out");
                        System.out.println("\t2) Remove Product");
                        System.out.println("\t3) Back to home screen");
                        cartCommand = scanner.nextInt();

                        switch (cartCommand) {
                            case 1:
                                checkout(shoppingCart);
                                break;
                            case 2:
                                System.out.println("Enter the SKU of the product to remove from cart:");
                                int skuToRemove = scanner.nextInt();
                                Product productToRemove = store.findProductBySku(skuToRemove);
                                if(productToRemove != null){
                                    shoppingCart.removeItem(productToRemove);
                                    System.out.println(productToRemove.getProductName()+ " removed from cart.");
                                } else {
                                    System.out.println("Product not Found.");
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Command not found.");
                        }
                    } while (cartCommand != 3);
                    break;
                case 3:
                    System.out.println("Thank you for shopping.");
                    break;
                default:
                    System.out.println("Command not found.");
            }

        } while (userIn != 3);
    }

    //method to display products
    private static void displayProducts(ArrayList<Product> products) {
        System.out.println("Products: ");
        for (int counter1 = 0; counter1 < products.size(); counter1++) {
            Product product = products.get(counter1);
            System.out.println(product.getSku() + ". " + product.getProductName() + ", $" + product.getPrice() + " " + product.getDepartment());
        }
    }

    //method to display items in cart
    private static void displayCart(ArrayList<Product> itemsInCart) {
        if (itemsInCart.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your Cart:");
            for (int counter2 = 0; counter2 < itemsInCart.size(); counter2++) {
                Product product = itemsInCart.get(counter2);
                System.out.println(product.getSku() + ". " + product.getProductName() + ", $" + product.getPrice() + " " + product.getDepartment());
            }
        }

    }
    // method to check out
    private static void checkout(ShoppingCart shoppingCart) {
        // calculate total sales amount
        float totalSalesAmount = 0;
        ArrayList<Product> itemsInCart = shoppingCart.getItemsInCart();
        for (Product product : itemsInCart) {
            totalSalesAmount += product.getPrice();
        }
        System.out.println("Total Sales Amount: $" + String.format("%.2f",totalSalesAmount));

        // prompt the user for payment
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter payment amount:");
        float paymentAmount = scanner.nextFloat();

        // verify payment amount
        if (paymentAmount < totalSalesAmount) {
            System.out.println("Insufficient payment. Payment amount must cover the total sales amount.");
            return;
        }

        // calculate change
        float change = paymentAmount - totalSalesAmount;
        System.out.println("Change: $" + String.format("%.2f",change));

        // print sales receipt to screen
        printSalesReceipt(itemsInCart, totalSalesAmount, paymentAmount, change);

    }

    // method to print sales receipt
    private static void printSalesReceipt(ArrayList<Product> itemsInCart, float totalSalesAmount, float paymentAmount, float change) {
        // get current date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy-HH:mm");
        String formattedDateTime = now.format(formatter);

        // print sales receipt
        System.out.println("Sales Receipt:");
        System.out.println("Order Date: " + formattedDateTime);
        System.out.println("Sales Total: $" + String.format("%.2f",totalSalesAmount));
        System.out.println("Amount Paid: $" + String.format("%.2f",paymentAmount));
        System.out.println("Change Given: $" + String.format("%.2f",change));
        System.out.println("Items:");
        for (Product product : itemsInCart) {
            System.out.println(product.getSku() + ". " + product.getProductName() + ", $" + String.format("%.2f", product.getPrice()));
        }


    }
}