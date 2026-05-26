package com.sarvesh.bfhl.util;

import java.util.List;

/**
 * Utility for building the alternating-caps concat string from alphabets in reverse order.
 *
 * Logic:
 *   1. Join all uppercase alphabets (already uppercased) into one continuous character sequence.
 *   2. Reverse the full character sequence.
 *   3. Apply alternating caps starting with uppercase for index 0:
 *      even index → uppercase, odd index → lowercase.
 *
 * Example: alphabets = ["A", "ABCD", "DOE"]
 *   joined  = "AABCDDOE"
 *   reversed = "EODDCBAA"
 *   alternating caps = "EoDdCbAa"
 */
public final class ConcatStringBuilder {

    private ConcatStringBuilder() {}

    /**
     * Builds the alternating-caps concat string.
     *
     * @param uppercasedAlphabets list of already-uppercased alphabet tokens
     * @return the alternating-caps string
     */
    public static String build(List<String> uppercasedAlphabets) {
        if (uppercasedAlphabets == null || uppercasedAlphabets.isEmpty()) {
            return "";
        }

        // 1. Join all alphabets into one string (already uppercased)
        String joined = String.join("", uppercasedAlphabets);

        // 2. Reverse
        String reversed = new StringBuilder(joined).reverse().toString();

        // 3. Alternating caps: index 0 → uppercase, index 1 → lowercase, ...
        StringBuilder result = new StringBuilder(reversed.length());
        for (int i = 0; i < reversed.length(); i++) {
            char c = reversed.charAt(i);
            if (i % 2 == 0) {
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
        }
        return result.toString();
    }
}
