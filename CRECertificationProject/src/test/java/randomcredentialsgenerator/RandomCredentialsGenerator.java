package randomcredentialsgenerator;

import java.util.Random;
import java.util.UUID;

public class RandomCredentialsGenerator {

    public static String generateRandomEmail() {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuilder prefix = new StringBuilder();
        int prefixLength = random.nextInt(10) + 5;
        for (int i = 0; i < prefixLength; i++) {
            prefix.append(letters.charAt(random.nextInt(letters.length())));
        }
        String uniqueID = UUID.randomUUID().toString().substring(0, 8);
        String[] domains = {"@exemplo.com", "@dominio.net", "@email.org"};
        String domain = domains[random.nextInt(domains.length)];
        return prefix + uniqueID + domain;
    }

    public static String generateRandomPassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "@#$%&/()=?";
        java.util.Random random = new java.util.Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length - 1; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        sb.append(specialCharacters.charAt(random.nextInt(specialCharacters.length())));
        return sb.toString();
    }

    public static String generateRandomName(int lengthName) {
        String consonants = "bcdfghjklmnpqrstvwxyz";
        String vowels = "aeiou";
        java.util.Random randomName = new java.util.Random();
        StringBuilder sbName = new StringBuilder();
        for (int i = 0; i < lengthName; i++) {
            if (i % 2 == 0) {
                sbName.append(consonants.charAt(randomName.nextInt(consonants.length())));
            } else {
                sbName.append(vowels.charAt(randomName.nextInt(vowels.length())));
            }
        }
        return sbName.toString().substring(0, 1).toUpperCase() + sbName.toString().substring(1);
    }
    
 // New method to generate a random number
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        // Ensure that the min and max values are in the correct order
        return random.nextInt((max - min) + 1) + min;
    }

    public static String generateRandomZipCode() {
        Random random = new Random();
        
        // Generate the first 4 digits (from 1000 to 9999)
        int firstPart = random.nextInt(9000) + 1000; // Ensures a 4-digit number
        
        // Generate the second 3 digits (from 100 to 999)
        int secondPart = random.nextInt(900) + 100; // Ensures a 3-digit number
        
        return firstPart + "-" + secondPart; // Format as ####-###
    }
    
    

}
