package com.github.magyariotto.Validation;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class IntegerValidator implements Predicate<String> {

    @Override
    public boolean test(String input) {
        try {
            Integer.valueOf(input);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number.");
            return false;
        }
    }
}
