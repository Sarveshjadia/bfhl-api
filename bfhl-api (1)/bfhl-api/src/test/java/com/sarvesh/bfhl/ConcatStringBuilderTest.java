package com.sarvesh.bfhl.util;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcatStringBuilderTest {

    @Test
    void build_exampleC_returnsExpected() {
        // alphabets = ["A", "ABCD", "DOE"] → already uppercased
        List<String> alphabets = List.of("A", "ABCD", "DOE");
        // joined = "AABCDDOE" → reversed = "EODDCBAA" → alternating caps = "EoDdCbAa"
        assertEquals("EoDdCbAa", ConcatStringBuilder.build(alphabets));
    }

    @Test
    void build_exampleA_returnsExpected() {
        // input: ["a","1","334","4","R","$"] → alphabets = ["A","R"]
        // joined = "AR" → reversed = "RA" → alternating caps = "Ra"
        List<String> alphabets = List.of("A", "R");
        assertEquals("Ra", ConcatStringBuilder.build(alphabets));
    }

    @Test
    void build_exampleB_returnsExpected() {
        // input: ["2","a","y","4","&","-","*","5","92","b"] → alphabets = ["A","Y","B"]
        // joined = "AYB" → reversed = "BYA" → alternating caps = "ByA"
        List<String> alphabets = List.of("A", "Y", "B");
        assertEquals("ByA", ConcatStringBuilder.build(alphabets));
    }

    @Test
    void build_emptyList_returnsEmptyString() {
        assertEquals("", ConcatStringBuilder.build(Collections.emptyList()));
    }

    @Test
    void build_nullList_returnsEmptyString() {
        assertEquals("", ConcatStringBuilder.build(null));
    }

    @Test
    void build_singleChar_returnsUppercase() {
        assertEquals("A", ConcatStringBuilder.build(List.of("A")));
    }
}
