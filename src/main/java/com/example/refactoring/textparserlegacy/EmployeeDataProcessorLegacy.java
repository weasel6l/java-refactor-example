package com.example.refactoring.textparserlegacy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDataProcessorLegacy {

    public static void main(final String[] args) {
        System.out.println("Starting the application...");
        String fPath = parseArgs(args);
        if (fPath != null) {
            procEmpData(fPath);
        }
        System.out.println("Application finished.");
    }

    private static String parseArgs(final String[] args) {
        if (args.length < 2 || !"-f".equals(args[0])) {
            System.out.println("Usage: java EmployeeDataProcessorLegacy -f <file-path>");
            return null;
        }
        return args[1];
    }

    private static void procEmpData(final String fPath) {
        BufferedReader empRd = null;
        try {
            empRd = new BufferedReader(new FileReader(fPath));
            List<EmployeeLegacy> emps = new ArrayList<>();
            String ln;
            while ((ln = empRd.readLine()) != null) {
                String[] tks = ln.trim().toUpperCase().split("\\s+");
                if (tks.length == 3) {
                    emps.add(new EmployeeLegacy(tks[0], tks[1], tks[2]));
                }
            }

            if (emps.isEmpty()) {
                System.out.println("Failed to read employee data from file: " + fPath);
            } else {
                for (EmployeeLegacy emp : emps) {
                    System.out.println(emp);
                }
            }
        } catch (IOException e) {
            System.out.println("Failed to read employee data from file: " + fPath);
        } finally {
            if (empRd != null) {
                try {
                    empRd.close();
                } catch (IOException e) {
                    System.out.println("Failed to close file reader.");
                }
            }
        }
    }
}
