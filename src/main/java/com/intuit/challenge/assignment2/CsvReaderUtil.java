package com.intuit.challenge.assignment2;

import java.io.*;
import java.util.*;

/**
 * Utility to read employee CSV data from resources folder.
 */
public class CsvReaderUtil {

    public static List<Employee> readCSV(String fileName) {
        List<Employee> list = new ArrayList<>();

        try (InputStream is = CsvReaderUtil.class.getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                System.out.println("ERROR: CSV file '" + fileName + "' not found in resources!");
                return list;
            }

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    list.add(new Employee(p[0].trim(), p[1].trim(), Double.parseDouble(p[2].trim())));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
