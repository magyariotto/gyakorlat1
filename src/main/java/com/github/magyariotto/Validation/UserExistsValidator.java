package com.github.magyariotto.Validation;

import com.github.magyariotto.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@RequiredArgsConstructor
public class UserExistsValidator implements Predicate<String> {
    private final UserRepository userRepository;

    @Override
    public boolean test(String username) {
        if(isBlank(username)){
            return true;
        }
        boolean result = userRepository.usernameExists(username);
        if(!result){
            System.out.println("User not found.");
        }
        return result;
    }
}
