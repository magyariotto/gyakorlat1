package com.github.magyariotto.Validation;


import org.springframework.stereotype.Component;

import java.util.function.Predicate;

@Component
public class PositivNumberValidation implements Predicate<Integer> {

    @Override
    public boolean test(Integer integer) {
        if(integer < 0){
            System.out.println("Number not be positive.");
            return false;
        }
        return true;
    }
}
