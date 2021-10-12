/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        // Read input from file "exercise42_input.txt"
        ArrayList<String> data = readEmployeeData("exercise42_input.txt");

        // Process the data
        ArrayList<Employee> employees = processEmployeeData(data);

        // Display the list as a formatted table.
        System.out.println(createEmployeeTable(employees));
    }

    // Precondition: fileName is the name of the employee data file.
    // Post-condition: Returns the contents of the file as a String ArrayList of its lines.
    public static ArrayList<String> readEmployeeData(String fileName) {
        // Open the file and go line by line, adding each line to an array.
        // Return the array once all lines have been read.

        // Create array.
        ArrayList<String> data = new ArrayList<>();

        // Open file
        try {
            File file = new File(fileName);

            // Scan file line by line
            Scanner fileReader = new Scanner(file);
            while (fileReader.hasNextLine())
                // Add the line to the array.
                data.add(fileReader.nextLine());

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return data;
    }

    // Precondition: data is an ArrayList<String> of the input file's contents.
    // Post-condition: Processes each line of employee data into an Employee instance and returns an ArrayList of all employees.
    public static ArrayList<Employee> processEmployeeData(ArrayList<String> data) {
        // Loop through the array. For each line, separate the values by commas.
        // Create a new Employee with the values and add it to the Employee ArrayList.

        ArrayList<Employee> employees = new ArrayList<>();

        // For each index in the array.
        for (String line : data) {

            // Separate the values out.
            String[] values = line.split(",");

            // Use the values to create a new Employee and add it to the ArrayList.
            employees.add(new Employee(values[1], values[0], Integer.parseInt(values[2])));
        }

        // Return the list of Employees.
        return employees;
    }

    // Precondition: employees is an ArrayList of Employees.
    // Post-condition: Returns list of Employees in a formatted table as a String.
    public static String createEmployeeTable(ArrayList<Employee> employees) {
        // Loop through the list of Employees and append each Employee's values to a main output String.
        // Return the string to be printed out.

        String output = "Last      First     Salary\n--------------------------\n";

        // Iterate through each employee.
        for (Employee e : employees) {

            // Process its data into a readable string.
            String first = e.first;
            String last = e.last;
            while (first.length() < 10)
                first += " ";
            while (last.length() < 10)
                last += " ";

            String line = String.format("%s%s%s\n", last, first, e.salary);

            // Append this string to the output.
            output += line;
        }

        return output;
    }
}