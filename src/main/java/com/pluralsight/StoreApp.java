package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    while (true) {
        System.out.println("""
                Welcome to the Store App Please Make a Following Selection\s
                1- List all products
                2- Lookup a product by its id
                3- Find all products within a price range
                4- Add a new product
                5- Quit the application""");
        int input = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Product> inventory = getInventory();

        switch (input) {
            case 1:
                inventory.sort(Comparator.comparingInt(Product::getId));
                for (Product p : inventory) {
                    System.out.printf("id: %d %s - Price: $%.2f\n",
                            p.getId(), p.getName(), p.getPrice());
                }
                System.out.println("Press ENTER to continue...");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the product id:");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (Product p : inventory) {
                    if (p.getId() == id) {
                        System.out.printf("id: %d %s - Price: $%.2f\n",p.getId(), p.getName(), p.getPrice());
                    }else {
                        System.out.println("Invalid product id!");
                    }
                }
                System.out.println("Press ENTER to continue...");
                scanner.nextLine();
                break;

        }
    }
    }

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<Product>();
// this method loads product objects into inventory
// and its details are not shown
        try{
            FileReader fileReader = new FileReader("src/main/resources/inventory.csv");
            BufferedReader bufReader = new BufferedReader(fileReader);

            int count = 0;
            String input;
            while ((input = bufReader.readLine()) != null) {
                String[] parts = input.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String productName = parts[1];
                float price = Float.parseFloat(parts[2]);

                Product product = new Product(id, productName, price);

              inventory.add(product);
            }

        } catch (IOException e){
            System.out.println("An Unexpected Error Has Occurred.");
            e.printStackTrace();
        }
        return inventory;
    }
}
