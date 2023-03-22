package org.example;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    public static List<String> main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java FileReader <file>");
            System.exit(1);
        }

        String fileName = args[0];
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fileName))) {
            String line = reader.readLine();
            if (line == null) {
                System.err.println("The file is empty");
                return null;

            }
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }

        } catch (Exception e) {
            System.err.println("Error reading file:" + e.getMessage());

            System.exit(1);
        }

        int startIndex = Math.max(0, lines.size() - 5);

        if (!isTxtFile(fileName)) {
            System.err.println("The file is not a text file");
        } else if (containsSpecialCharacters(lines)) {
            System.err.println("The file contains special characters");
        } else if (lines.size() < 5 && lines.size() > 0) {
            System.err.println("File has less than 5 lines");
        } else {
            for (int i = startIndex; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        }
        return lines.subList(startIndex, lines.size());
    }

    public static boolean isTxtFile(String fileName) {
        String extension = fileName.substring(fileName.lastIndexOf(".") + 1);
        return extension.equals("txt");
    }

    public static boolean containsSpecialCharacters(List<String> lines) {
        for (String line : lines) {
            if (!line.matches("^[a-zA-Z0-9\\s]+$")) {
                return true;
            }
        }
        return false;
    }
}
