package com.pluralsight;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        Scanner scanner = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
        }
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
                //String formattedProduct = String.format("ID: %d | Product: %s | Price: %.2f", id, productName, price);
                System.out.printf("id: %d %s - Price: $%.2f\n", id, productName, price);

                count++;


            }






        } catch (IOException e){
            System.out.println("An Unexpected Error Has Occurred.");
            e.printStackTrace();
            }



    }

    public static ArrayList<Product> getInventory() {

        ArrayList<Product> inventory = new ArrayList<Product>();
// this method loads product objects into inventory
// and its details are not shown
        inventory.add(new Product(13, "Golden Apple", 10.00f));
        inventory.add(new Product(35, "Banana", 2.00f));
        inventory.add(new Product(12, "Cheese", 12.00f));
        inventory.add(new Product(53, "BBQ Sauce", 3.00f));
        inventory.add(new Product(41, "Milk", 15.00f));


        return inventory;
    }
}
