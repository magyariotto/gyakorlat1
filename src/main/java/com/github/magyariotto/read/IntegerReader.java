package com.github.magyariotto.read;

import com.github.magyariotto.Validation.IntegerValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IntegerReader {
    public final ValidationReader validationReader;
    public final IntegerValidator integerValidator;

    public int readNumber() {
        String numberString = validationReader.readInput(integerValidator);

        return Integer.parseInt(numberString);
    }
}
