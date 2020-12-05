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
public class WithdrawService {
    private final IntegerValidationReader integerValidationReader;
    private final PositivNumberValidation positivNumberValidation;
    private final UserRepository userRepository;

    public void withdraw(User user){
        System.out.println("Now much do you want to withdraw?Avaliable balance: " + user.getBalance());
        int withdrawValue = integerValidationReader.readNumber(positivNumberValidation);

        if(withdrawValue > user.getBalance()){
            System.err.println("You cannot withdraw so much.");
            withdraw(user);
            return;
        }

        user.withdrawBalance(withdrawValue);
        userRepository.save(user);
        System.out.println("Withdraw succesful.");
    }
}
