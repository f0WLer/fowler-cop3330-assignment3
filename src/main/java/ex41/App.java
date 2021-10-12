/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */

package ex41;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        // Read input from file "exercise41_input.txt"
        ArrayList<Name> names = readNames("exercise41_input.txt");

        // Sort list alphabetically
        sortNames(names);

        // Write output to file "exercise41_output.txt"
        writeNames(names, "exercise41_output.txt");
    }

    // Precondition: fileName is the name of the file including a list of names in the format "Last, First".
    // Post-condition: returns a Name ArrayList corresponding to those in the file.
    public static ArrayList<Name> readNames(String fileName) {
        // Open the file and go line by line, separating each string into last and first names.
        // For each line, create a new Name and add it to an ArrayList.
        // Return the ArrayList.

        // Create array.
        ArrayList<Name> names = new ArrayList<>();

        // Open file
        try {
            File file = new File(fileName);

            // Scan file line by line
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();

                // Split string into first and last names.
                String[] temp = data.split(", ");

                // Create new Name and add it to the array.
                names.add(new Name(temp[1], temp[0]));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return names;
    }

    // Precondition: names is an ArrayList of Names.
    // Post-condition: alphabetically sorts the list by last name.
    public static void sortNames(ArrayList<Name> names) {
        // Loop through the array. For each slot, find the lowest 'lexicographic valued'
        // name out of the names to the right and put it in that slot.
        // The resulting array should be sorted lexicographically.

        Name temp;

        // For each index in the array
        for (int i = 0; i < names.size(); i++) {

            // For each name to the right
            for (int j = i + 1; j < names.size(); j++) {

                // Sort by last name. If the last names match, sort by first name.
                String name1 = (names.get(i).last.compareTo(names.get(j).last) == 0) ? names.get(i).first : names.get(i).last;
                String name2 = (names.get(i).last.compareTo(names.get(j).last) == 0) ? names.get(j).first : names.get(j).last;

                // If the name is 'lexicographically smaller' than the current one, swap them.
                if (name1.compareTo(name2) > 0) {
                    temp = names.get(i);
                    names.set(i, names.get(j));
                    names.set(j, temp);
                }
            }
        }
    }

    // Precondition: names is an ArrayList of Names, fileName is the name of the file to be written to.
    // Post-condition: Writes the list of names to the file.
    private static void writeNames(ArrayList<Name> names, String fileName) {
        // Create a file and iterate through the list of Names,
        // writing each first and last name to a separate line in the file.

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

            // For each name.
            for (Name name : names) {

                // Write the name to the current line.
                fileWriter.append(String.format("%s, %s\n", name.last, name.first));
                System.out.printf("%s, %s\n", name.last, name.first);
            }

            // Close the file.
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}