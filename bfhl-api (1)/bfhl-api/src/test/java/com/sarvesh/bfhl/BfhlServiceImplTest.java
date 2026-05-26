package com.sarvesh.bfhl.service;

import com.sarvesh.bfhl.dto.BfhlRequest;
import com.sarvesh.bfhl.dto.BfhlResponse;
import com.sarvesh.bfhl.service.impl.BfhlServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceImplTest {

    private BfhlService service;

    @BeforeEach
    void setUp() {
        service = new BfhlServiceImpl();
    }

    @Test
    void processData_exampleA_returnsCorrectResponse() {
        BfhlRequest request = new BfhlRequest(List.of("a", "1", "334", "4", "R", "$"));
        BfhlResponse response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals("sarvesh_jadia_07042005", response.getUserId());
        assertEquals("sarveshjadia230885@acropolis.in", response.getEmail());
        assertEquals("0827CS231240", response.getRollNumber());

        assertEquals(List.of("1"), response.getOddNumbers());
        assertEquals(List.of("334", "4"), response.getEvenNumbers());
        assertEquals(List.of("A", "R"), response.getAlphabets());
        assertEquals(List.of("$"), response.getSpecialCharacters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    void processData_exampleB_returnsCorrectResponse() {
        BfhlRequest request = new BfhlRequest(List.of("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));
        BfhlResponse response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of("5"), response.getOddNumbers());
        assertEquals(List.of("2", "4", "92"), response.getEvenNumbers());
        assertEquals(List.of("A", "Y", "B"), response.getAlphabets());
        assertEquals(List.of("&", "-", "*"), response.getSpecialCharacters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    void processData_exampleC_onlyAlphabets() {
        BfhlRequest request = new BfhlRequest(List.of("A", "ABCD", "DOE"));
        BfhlResponse response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of(), response.getOddNumbers());
        assertEquals(List.of(), response.getEvenNumbers());
        assertEquals(List.of("A", "ABCD", "DOE"), response.getAlphabets());
        assertEquals(List.of(), response.getSpecialCharacters());
        assertEquals("0", response.getSum());
        assertEquals("EoDdCbAa", response.getConcatString());
    }

    @Test
    void processData_emptyData_returnsZeroSumAndEmptyLists() {
        BfhlRequest request = new BfhlRequest(List.of());
        BfhlResponse response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(List.of(), response.getOddNumbers());
        assertEquals(List.of(), response.getEvenNumbers());
        assertEquals(List.of(), response.getAlphabets());
        assertEquals(List.of(), response.getSpecialCharacters());
        assertEquals("0", response.getSum());
        assertEquals("", response.getConcatString());
    }

    @Test
    void processData_numbersReturnedAsStrings() {
        BfhlRequest request = new BfhlRequest(List.of("1", "2"));
        BfhlResponse response = service.processData(request);

        // Numbers must be returned as strings
        assertTrue(response.getOddNumbers().contains("1"));
        assertTrue(response.getEvenNumbers().contains("2"));
    }
}
