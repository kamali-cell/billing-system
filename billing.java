package com.billing;

import java.util.Scanner;

/**
 * Internet Data Usage Billing System
 * Calculates monthly bills based on customer plans and data consumption.
 */
public class App {
    public static void main(String[] args) {
        // Using System.in explicitly for interactive console compatibility
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=================================================");
        System.out.println("    INTERNET DATA USAGE BILLING SYSTEM          ");
        System.out.println("=================================================");
        
        // Loop allows processing multiple customers sequentially
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String customerName = scanner.nextLine().trim();
            
            // Check for exit condition
            if (customerName.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (customerName.isEmpty()) {
                System.out.println("[Error] Customer name cannot be empty. Please try again.");
                continue;
            }

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String planType = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter Data Consumed (in GB): ");
            double dataConsumed;
            try {
                dataConsumed = Double.parseDouble(scanner.nextLine());
                if (dataConsumed < 0) {
                    System.out.println("[Error] Data consumed cannot be negative.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid data input. Please enter a valid number.");
                continue;
            }

            // Billing configuration variables
            double baseRate = 0.0;
            double dataLimit = 0.0;
            double extraChargePerGB = 0.0;
            boolean validPlan = true;

            // Plan evaluation logic
            switch (planType) {
                case "basic":
                    baseRate = 15.00;
                    dataLimit = 10.00;      // 10 GB Limit
                    extraChargePerGB = 2.00; // $2.00 per excess GB
                    break;
                case "standard":
                    baseRate = 30.00;
                    dataLimit = 50.00;      // 50 GB Limit
                    extraChargePerGB = 1.50; // $1.50 per excess GB
                    break;
                case "premium":
                    baseRate = 50.00;
                    dataLimit = 100.00;     // 100 GB Limit
                    extraChargePerGB = 1.00; // $1.00 per excess GB
                    break;
                default:
                    System.out.println("[Warning] Unknown plan type. Defaulting to Basic plan metrics.");
                    baseRate = 15.00;
                    dataLimit = 10.00;
                    extraChargePerGB = 2.00;
                    planType = "basic (defaulted)";
                    break;
            }

            // Calculations
            double excessData = Math.max(0, dataConsumed - dataLimit);
            double overageCharge = excessData * extraChargePerGB;
            double totalBill = baseRate + overageCharge;

            // Invoice display block
            System.out.println("\n-------------------------------------------------");
            System.out.println("                MONTHLY INVOICE                  ");
            System.out.println("-------------------------------------------------");
            System.out.printf(" Customer Name   : %s\n", customerName);
            System.out.printf(" Selected Plan   : %s\n", planType.toUpperCase());
            System.out.printf(" Data Allowance  : %.2f GB\n", dataLimit);
            System.out.printf(" Data Consumed   : %.2f GB\n", dataConsumed);
            System.out.printf(" Excess Usage    : %.2f GB\n", excessData);
            System.out.println("-------------------------------------------------");
            System.out.printf(" Base Plan Fee   : $%.2f\n", baseRate);
            System.out.printf(" Overage Charge  : $%.2f\n", overageCharge);
            System.out.printf(" Total Amount Due: $%.2f\n", totalBill);
            System.out.println("-------------------------------------------------");
        }
        
        System.out.println("\nSystem closed. Thank you for using the Billing System.");
        scanner.close();
    }
}
package com.billing;

import java.util.Scanner;

/**
 * Internet Data Usage Billing System
 * Calculates monthly bills based on customer plans and data consumption.
 */
public class App {
    public static void main(String[] args) {
        // Using System.in explicitly for interactive console compatibility
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=================================================");
        System.out.println("    INTERNET DATA USAGE BILLING SYSTEM          ");
        System.out.println("=================================================");
        
        // Loop allows processing multiple customers sequentially
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String customerName = scanner.nextLine().trim();
            
            // Check for exit condition
            if (customerName.equalsIgnoreCase("exit")) {
                break;
            }
            
            if (customerName.isEmpty()) {
                System.out.println("[Error] Customer name cannot be empty. Please try again.");
                continue;
            }

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String planType = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter Data Consumed (in GB): ");
            double dataConsumed;
            try {
                dataConsumed = Double.parseDouble(scanner.nextLine());
                if (dataConsumed < 0) {
                    System.out.println("[Error] Data consumed cannot be negative.");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("[Error] Invalid data input. Please enter a valid number.");
                continue;
            }

            // Billing configuration variables
            double baseRate = 0.0;
            double dataLimit = 0.0;
            double extraChargePerGB = 0.0;
            boolean validPlan = true;

            // Plan evaluation logic
            switch (planType) {
                case "basic":
                    baseRate = 15.00;
                    dataLimit = 10.00;      // 10 GB Limit
                    extraChargePerGB = 2.00; // $2.00 per excess GB
                    break;
                case "standard":
                    baseRate = 30.00;
                    dataLimit = 50.00;      // 50 GB Limit
                    extraChargePerGB = 1.50; // $1.50 per excess GB
                    break;
                case "premium":
                    baseRate = 50.00;
                    dataLimit = 100.00;     // 100 GB Limit
                    extraChargePerGB = 1.00; // $1.00 per excess GB
                    break;
                default:
                    System.out.println("[Warning] Unknown plan type. Defaulting to Basic plan metrics.");
                    baseRate = 15.00;
                    dataLimit = 10.00;
                    extraChargePerGB = 2.00;
                    planType = "basic (defaulted)";
                    break;
            }

            // Calculations
            double excessData = Math.max(0, dataConsumed - dataLimit);
            double overageCharge = excessData * extraChargePerGB;
            double totalBill = baseRate + overageCharge;

            // Invoice display block
            System.out.println("\n-------------------------------------------------");
            System.out.println("                MONTHLY INVOICE                  ");
            System.out.println("-------------------------------------------------");
            System.out.printf(" Customer Name   : %s\n", customerName);
            System.out.printf(" Selected Plan   : %s\n", planType.toUpperCase());
            System.out.printf(" Data Allowance  : %.2f GB\n", dataLimit);
            System.out.printf(" Data Consumed   : %.2f GB\n", dataConsumed);
            System.out.printf(" Excess Usage    : %.2f GB\n", excessData);
            System.out.println("-------------------------------------------------");
            System.out.printf(" Base Plan Fee   : $%.2f\n", baseRate);
            System.out.printf(" Overage Charge  : $%.2f\n", overageCharge);
            System.out.printf(" Total Amount Due: $%.2f\n", totalBill);
            System.out.println("-------------------------------------------------");
        }
        
        System.out.println("\nSystem closed. Thank you for using the Billing System.");
        scanner.close();
    }
}
