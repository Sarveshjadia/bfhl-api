package com.sarvesh.bfhl.service.impl;

import com.sarvesh.bfhl.dto.BfhlRequest;
import com.sarvesh.bfhl.dto.BfhlResponse;
import com.sarvesh.bfhl.service.BfhlService;
import com.sarvesh.bfhl.util.ConcatStringBuilder;
import com.sarvesh.bfhl.util.DataClassifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

    private static final String USER_ID      = "sarvesh_jadia_07042005";
    private static final String EMAIL        = "sarveshjadia230885@acropolis.in";
    private static final String ROLL_NUMBER  = "0827CS231240";

    @Override
    public BfhlResponse processData(BfhlRequest request) {
        List<String> data = request.getData();

        List<String> oddNumbers       = new ArrayList<>();
        List<String> evenNumbers      = new ArrayList<>();
        List<String> alphabets        = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        long sum = 0;

        for (String token : data) {
            if (token == null) continue;

            if (DataClassifier.isNumber(token)) {
                long num = Long.parseLong(token.trim());
                sum += num;
                if (DataClassifier.isEven(num)) {
                    evenNumbers.add(token.trim());
                } else {
                    oddNumbers.add(token.trim());
                }
            } else if (DataClassifier.isAlpha(token)) {
                alphabets.add(token.trim().toUpperCase());
            } else {
                specialCharacters.add(token.trim());
            }
        }

        String concatString = ConcatStringBuilder.build(alphabets);

        return BfhlResponse.builder()
                .isSuccess(true)
                .userId(USER_ID)
                .email(EMAIL)
                .rollNumber(ROLL_NUMBER)
                .oddNumbers(oddNumbers)
                .evenNumbers(evenNumbers)
                .alphabets(alphabets)
                .specialCharacters(specialCharacters)
                .sum(String.valueOf(sum))
                .concatString(concatString)
                .build();
    }
}
