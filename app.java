package com.billing;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Internet Data Usage Billing System ===");
        
        while (true) {
            System.out.print("\nEnter Customer Name (or type 'exit' to quit): ");
            String name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            System.out.print("Enter Plan Type (Basic, Standard, Premium): ");
            String plan = scanner.nextLine().trim().toLowerCase();

            System.out.print("Enter Data Consumed (in GB): ");
            double dataConsumed;
            try {
                dataConsumed = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid data input. Please enter numbers only.");
                continue;
            }

            double baseRate = 0;
            double dataLimit = 0;
            double extraChargePerGB = 0;

            if (plan.equals("basic")) {
                baseRate = 15.00; dataLimit = 10.0; extraChargePerGB = 2.00;
            } else if (plan.equals("standard")) {
                baseRate = 30.00; dataLimit = 50.0; extraChargePerGB = 1.50;
            } else if (plan.equals("premium")) {
                baseRate = 50.00; dataLimit = 100.0; extraChargePerGB = 1.00;
            } else {
                System.out.println("Unknown plan type. Defaulting to Basic plan.");
                baseRate = 15.00; dataLimit = 10.0; extraChargePerGB = 2.00;
                plan = "basic (defaulted)";
            }

            double excessData = Math.max(0, dataConsumed - dataLimit);
            double overageCharge = excessData * extraChargePerGB;
            double totalBill = baseRate + overageCharge;

            System.out.println("\n--- Monthly Invoice ---");
            System.out.printf("Customer Name : %s\n", name);
            System.out.printf("Selected Plan : %s\n", plan.toUpperCase());
            System.out.printf("Total Bill Due: $%.2f\n", totalBill);
            System.out.println("-----------------------");
        }
        scanner.close();
    }

    // Required for the automated JUnit Test validation
    public double calculateBill(String plan, double data) {
        double baseRate = 0, limit = 0, extraCharge = 0;
        if (plan.equalsIgnoreCase("basic")) { baseRate = 15.00; limit = 10.0; extraCharge = 2.00; }
        else if (plan.equalsIgnoreCase("standard")) { baseRate = 30.00; limit = 50.0; extraCharge = 1.50; }
        else if (plan.equalsIgnoreCase("premium")) { baseRate = 50.00; limit = 100.0; extraCharge = 1.00; }
        return baseRate + (Math.max(0, data - limit) * extraCharge);
    }
}
