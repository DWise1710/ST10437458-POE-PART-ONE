/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.st10437458_poe_part_one;
import java.util.Scanner;

/**
 *
 * @author RC_Student_lab
 */
public class ST10437458_POE_PART_ONE {
    // Variables to store account details
    private static String registeredUsername;
    private static String registeredPassword;
    private static String firstName;
    private static String lastName;

    // Method to check if the username is valid (contains an underscore and is no more than 5 characters long)
    public static boolean isValidUsername(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check if the password meets complexity requirements
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpperCase = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialChar = true;
            }
        }

        return hasUpperCase && hasNumber && hasSpecialChar;
    }

    // Method to register a new user
    public static void createAccount(Scanner scanner) {
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();

        System.out.print("Enter a username (must contain an underscore and be no more than 5 characters): ");
        String username = scanner.nextLine();

        System.out.print("Enter a password (at least 8 characters, contain a capital letter, a number, and a special character): ");
        String password = scanner.nextLine();

        // Validate username and password
        if (!isValidUsername(username)) {
            System.out.println("Error: Username must contain an underscore and be no more than 5 characters long.");
            return;
        }

        if (!isValidPassword(password)) {
            System.out.println("Error: Password must be at least 8 characters long, contain a capital letter, a number, and a special character.");
            return;
        }

        // Store the validated username and password
        registeredUsername = username;
        registeredPassword = password;

        System.out.println("Account successfully created for " + firstName + " " + lastName + "!");
    }

    // Method to log in the user
    public static void login(Scanner scanner) {
        if (registeredUsername == null || registeredPassword == null) {
            System.out.println("No account found. Please create an account first.");
            return;
        }

        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // Check if the entered username and password match the registered details
        if (username.equals(registeredUsername) && password.equals(registeredPassword)) {
            System.out.println("Login successful! Welcome back, " + firstName + " " + lastName + "!");
        } else {
            System.out.println("Login failed: Incorrect username or password.");
        }
    }
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    login(scanner);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
    
   