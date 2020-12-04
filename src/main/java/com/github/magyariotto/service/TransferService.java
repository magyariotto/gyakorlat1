package com.github.magyariotto.service;

import com.github.magyariotto.Validation.PositivNumberValidation;
import com.github.magyariotto.Validation.UserExistsValidator;
import com.github.magyariotto.read.IntegerValidationReader;
import com.github.magyariotto.read.ValidationReader;
import com.github.magyariotto.repository.user.User;
import com.github.magyariotto.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
@Slf4j
public class TransferService {
    private final IntegerValidationReader integerValidationReader;
    private final PositivNumberValidation positivNumberValidation;
    private final ValidationReader validationReader;
    private final UserExistsValidator userExistsValidator;
    private final UserRepository userRepository;

    public void transfer(User user) {
        System.out.println("How much do you want to transfer?.Avaliable balance: " + user.getBalance());
        int transferValue = integerValidationReader.readNumber(positivNumberValidation);

        if(transferValue == 0){
            System.out.println("Transaction cancelled.");
            return;
        }

        if (transferValue > user.getBalance()) {
            System.err.println("You cannot transferValue so much.");
            transfer(user);
            return;
        }

        System.out.println("Who do you want to send money to?");
        String username = validationReader.readInput(userExistsValidator);
        if(isBlank(username)){
            return;
        }

        System.out.println(String.format("Transferring %s money to %s", transferValue, username));
        User target = userRepository.findByUsername(username);

        target.increaseBalance(transferValue);
        user.decreaseBalance(transferValue);

        System.out.println("Transaction succesful.");
    }
}
