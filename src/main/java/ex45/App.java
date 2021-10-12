/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */
package ex45;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App
{
    public static void main(String[] args){
        // Read input file
        String content;
        try {
            content = Files.readString(Paths.get(System.getProperty("user.dir") + "/exercise45_input.txt"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Find and Replace
        content = content.replaceAll("utilize", "use");

        // Output to file
        writeToFile(content);
    }

    // Precondition: content is the String of text to write to a file.
    // Post-condition: Prompts user for the name of the file and saves the file.
    public static void writeToFile(String content) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for the file name.
        System.out.print("Filename: ");
        String fileName = scanner.nextLine();

        // Create the file.
        try {
            new File(fileName).createNewFile();
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
            return;
        }

        // Write to the file.
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            fileWriter.append(content);

            // Close the file.
            fileWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}