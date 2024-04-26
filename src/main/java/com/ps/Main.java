package com.ps;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
}