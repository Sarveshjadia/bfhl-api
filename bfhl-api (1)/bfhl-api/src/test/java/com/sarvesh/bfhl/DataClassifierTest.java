package com.sarvesh.bfhl.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DataClassifierTest {

    @Test
    void isNumber_validPositiveInteger_returnsTrue() {
        assertTrue(DataClassifier.isNumber("334"));
    }

    @Test
    void isNumber_validNegativeInteger_returnsTrue() {
        assertTrue(DataClassifier.isNumber("-5"));
    }

    @Test
    void isNumber_alphabetString_returnsFalse() {
        assertFalse(DataClassifier.isNumber("abc"));
    }

    @Test
    void isNumber_specialChar_returnsFalse() {
        assertFalse(DataClassifier.isNumber("$"));
    }

    @Test
    void isNumber_null_returnsFalse() {
        assertFalse(DataClassifier.isNumber(null));
    }

    @Test
    void isEven_evenNumber_returnsTrue() {
        assertTrue(DataClassifier.isEven(4));
        assertTrue(DataClassifier.isEven(334));
        assertTrue(DataClassifier.isEven(0));
    }

    @Test
    void isEven_oddNumber_returnsFalse() {
        assertFalse(DataClassifier.isEven(1));
        assertFalse(DataClassifier.isEven(5));
    }

    @Test
    void isAlpha_pureAlpha_returnsTrue() {
        assertTrue(DataClassifier.isAlpha("a"));
        assertTrue(DataClassifier.isAlpha("ABCD"));
        assertTrue(DataClassifier.isAlpha("DOE"));
    }

    @Test
    void isAlpha_mixedAlphaNumeric_returnsFalse() {
        assertFalse(DataClassifier.isAlpha("a1"));
    }

    @Test
    void isAlpha_specialChar_returnsFalse() {
        assertFalse(DataClassifier.isAlpha("$"));
    }

    @Test
    void isSpecialCharacter_specialChar_returnsTrue() {
        assertTrue(DataClassifier.isSpecialCharacter("$"));
        assertTrue(DataClassifier.isSpecialCharacter("&"));
        assertTrue(DataClassifier.isSpecialCharacter("-"));
        assertTrue(DataClassifier.isSpecialCharacter("*"));
    }

    @Test
    void isSpecialCharacter_number_returnsFalse() {
        assertFalse(DataClassifier.isSpecialCharacter("5"));
    }

    @Test
    void isSpecialCharacter_alpha_returnsFalse() {
        assertFalse(DataClassifier.isSpecialCharacter("A"));
    }
}
