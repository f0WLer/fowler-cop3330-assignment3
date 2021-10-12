/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */
package ex44;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args){
        ArrayList<Product> inventory = getInventoryFromJson(System.getProperty("user.dir") + "/exercise44_input.json");

        getProductInfo(inventory);
    }

    // Precondition: inventory is an ArrayList of Products.
    // Post-condition: Prompts the user for a product name until one is found and displays that Product's data.
    public static void getProductInfo(ArrayList<Product> inventory) {
        Scanner scanner = new Scanner(System.in);
        // Prompt for the product name.
        System.out.print("What is the product name? ");
        String query = scanner.nextLine();

        // Find the product.
        for (Product p : inventory) {

            // Product was found
            if (p.name.equalsIgnoreCase(query)) {

                // Display its info.
                System.out.printf("Name: %s\nPrice: %s\nQuantity: %s\n", p.name, p.price, p.quantity);
                return;
            }
        }

        // The product was not found. Prompt again.
        System.out.println("Sorry, that product was not found in our inventory.");
        getProductInfo(inventory);
    }

    // Precondition: path is the path of a json file containing product info.
    // Post-condition: Parses the file into an ArrayList of Products.
    public static ArrayList<Product> getInventoryFromJson(String path){
        ArrayList<Product> inventory = new ArrayList<>();

        // Read in JSON file.
        String json;
        try {
            json = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            e.printStackTrace();
            return inventory;
        }

        // Break the JSON into lines
        String[] lines = json.split("\n");

        for (int i = 2; i < lines.length - 2; i++) {
            String[] subString = lines[i].split(": ");

            String name = subString[1].split("\"")[1];
            float price = Float.parseFloat(subString[2].split(",")[0]);
            int quantity = Integer.parseInt(subString[3].split(" ")[0]);

            // Create a new Product and add it to the inventory.
            inventory.add(new Product(name, price, quantity));
        }

        return inventory;
    }
}