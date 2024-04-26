package com.ps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    //ArrayList to store products
    private ArrayList<Product> products;

    // Constructor
    public Store() {
        products = new ArrayList<>();
        readProductsFromFile("products.txt");
    }

    //method to read products from file and add to the products ArrayList
    private void readProductsFromFile(String filename) {
        try (BufferedReader bufReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    int sku = Integer.parseInt(parts[0].trim());
                    String productName = parts[1].trim();
                    float price = Float.parseFloat(parts[2].trim());
                    String department = parts[3].trim();
                    products.add(new Product(sku, productName, price, department));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading products from file");
        }
    }
    //method to read list of products
    public ArrayList<Product> getProducts(){
        return products;
    }
}
