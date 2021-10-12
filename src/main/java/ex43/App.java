/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */
package ex43;

import java.util.Locale;
import java.util.Scanner;

public class App
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt for name.
        System.out.print("Site name: ");
        String name = scanner.nextLine();

        // Prompt for author.
        System.out.print("Author: ");
        String author = scanner.nextLine();

        // JavaScript folder?
        System.out.print("Do you want a folder for JavaScript? ");
        String output = scanner.nextLine().toLowerCase(Locale.ROOT);
        boolean hasJS = (output.compareTo("y") == 0);

        // CSS folder?
        System.out.print("Do you want a folder for CSS? ");
        output = scanner.nextLine().toLowerCase(Locale.ROOT);
        boolean hasCSS = (output.compareTo("y") == 0);

        // Generate Website.
        new WebGen(name, author, hasJS, hasCSS);
    }
}