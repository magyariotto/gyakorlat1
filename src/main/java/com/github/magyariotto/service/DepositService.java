package com.github.magyariotto.service;

import com.github.magyariotto.Validation.PositivNumberValidation;
import com.github.magyariotto.read.IntegerValidationReader;
import com.github.magyariotto.repository.user.User;
import com.github.magyariotto.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class DepositService {
    private final IntegerValidationReader integerValidationReader;
    private final PositivNumberValidation positivNumberValidation;
    private final UserRepository userRepository;

    public void deposit(User user){
        System.out.println("Now much do you want to deposit?");
        int depositValue = integerValidationReader.readNumber(positivNumberValidation);

        user.increaseBalance(depositValue);
        userRepository.save(user);
        System.out.println("Deposit succesful.");
    }
}
