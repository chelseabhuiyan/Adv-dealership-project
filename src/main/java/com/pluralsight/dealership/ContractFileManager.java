package com.pluralsight.dealership;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static final String FILE_PATH = "contracts.txt";  // File to store contracts

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            String contractDetails = formatContract(contract);
            writer.append(contractDetails);
            writer.newLine();  // Append a new line after each contract entry
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}