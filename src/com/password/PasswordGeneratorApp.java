package com.password;

import java.util.Random;
import java.util.Scanner;

public class PasswordGeneratorApp {
	// Password Generate Method
    public static String generatePassword(int length) {

        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String special = "!@#$%^&*()-_=+[]{}|;:,.<>?";

        String allChars = upper + lower + numbers + special;

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        // ✅ Strong password rule: at least 1 char from each category
        password.append(upper.charAt(random.nextInt(upper.length())));
        password.append(lower.charAt(random.nextInt(lower.length())));
        password.append(numbers.charAt(random.nextInt(numbers.length())));
        password.append(special.charAt(random.nextInt(special.length())));

        // Remaining characters
        for (int i = 4; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle password (for better randomness)
        char[] passArray = password.toString().toCharArray();
        for (int i = 0; i < passArray.length; i++) {
            int j = random.nextInt(passArray.length);
            char temp = passArray[i];
            passArray[i] = passArray[j];
            passArray[j] = temp;
        }

        return new String(passArray);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===================================");
        System.out.println("      🔐 Password Generator");
        System.out.println("===================================");

        System.out.print("Enter password length (minimum 4): ");
        int length = sc.nextInt();

        if (length < 4) {
            System.out.println("❌ Password length must be at least 4!");
        } else {
            String password = generatePassword(length);
            System.out.println("✅ Generated Strong Password: " + password);
        }

        sc.close();
    }
}
