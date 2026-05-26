package com.sarvesh.bfhl.util;

/**
 * Utility class for classifying individual string tokens from the input data array.
 */
public final class DataClassifier {

    private DataClassifier() {
        // Utility class — no instantiation
    }

    /**
     * Returns true if the given token represents a valid integer number.
     */
    public static boolean isNumber(String token) {
        if (token == null || token.isBlank()) return false;
        try {
            Long.parseLong(token.trim());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Returns true if the number is even.
     */
    public static boolean isEven(long number) {
        return number % 2 == 0;
    }

    /**
     * Returns true if the token consists entirely of alphabetic characters (a-z, A-Z).
     */
    public static boolean isAlpha(String token) {
        if (token == null || token.isBlank()) return false;
        return token.chars().allMatch(Character::isLetter);
    }

    /**
     * Returns true if the token is a special character (not alphanumeric).
     * A token is considered a special character if it is NOT a number and NOT all-alpha.
     */
    public static boolean isSpecialCharacter(String token) {
        if (token == null || token.isBlank()) return false;
        return !isNumber(token) && !isAlpha(token);
    }
}
