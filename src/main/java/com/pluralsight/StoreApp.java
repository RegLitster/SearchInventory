package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {

        ArrayList<Product> inventory = getInventory();
        Scanner input = new Scanner(System.in);

        System.out.println("We carry the following inventory: ");
        for (Product p : inventory) {
            System.out.printf("id: %d %s - Price: $%.2f\n",
                    p.getId(), p.getName(), p.getPrice());
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
