package org.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> readLastFiveLines(String fileName) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        int startIndex = Math.max(0, lines.size() - 5);
        return lines.subList(startIndex, lines.size());
    }
}
