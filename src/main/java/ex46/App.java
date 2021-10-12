/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Alex Fowler
 */
package ex46;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("badger");
        keywords.add("mushroom");
        keywords.add("snake");

        ArrayList<Integer> freq = new ArrayList<>();
        for (String word : keywords)
            freq.add(0);

        // Read input file
        String content;
        try {
            content = Files.readString(Paths.get(System.getProperty("user.dir") + "/exercise46_input.txt"), StandardCharsets.US_ASCII);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Count the frequencies of each word.
        for (int i = 0; i < keywords.size(); i++) {
            content = content.replaceAll("\n", " ");
            String[] subStrings = content.split(" ");
            for (String s: subStrings) {
                if (s.equalsIgnoreCase(keywords.get(i))) {
                    int oldFreq = freq.get(i);
                    freq.set(i, oldFreq++);
                }
            }
            System.out.println(freq.get(i));
        }

        // Display the results
        while (freq.size() > 0) {
            int mostFreq = 0;
            int highestFreq = freq.get(0);
            for (int i = 1; i < freq.size(); i++) {
                if (freq.get(i) > highestFreq) {
                    mostFreq = i;
                    highestFreq = freq.get(i);
                }
            }
            System.out.printf("%s:\t%s\n", keywords.get(mostFreq), stars(freq.get(mostFreq)));
            freq.remove(mostFreq);
            keywords.remove(mostFreq);
        }
    }

    public static String stars(int num) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < num; i++) {
            output.append("*");
        }
        return output.toString();
    }
}

