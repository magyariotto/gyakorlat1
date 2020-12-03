package com.github.magyariotto.read;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class IntegerValidationReader {
    private final IntegerReader integerReader;

    public int readNumber(Predicate<Integer> validation){
        int input;
        do {
            input = integerReader.readNumber();
        }while (!validation.test(input));
        return input;
    }
}
