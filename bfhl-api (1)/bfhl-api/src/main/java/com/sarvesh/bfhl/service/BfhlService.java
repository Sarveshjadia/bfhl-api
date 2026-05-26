package com.sarvesh.bfhl.service;

import com.sarvesh.bfhl.dto.BfhlRequest;
import com.sarvesh.bfhl.dto.BfhlResponse;

public interface BfhlService {

    /**
     * Processes the input data array and returns categorized response.
     *
     * @param request the incoming request containing data array
     * @return BfhlResponse with categorized numbers, alphabets, special chars, sum and concat string
     */
    BfhlResponse processData(BfhlRequest request);
}
