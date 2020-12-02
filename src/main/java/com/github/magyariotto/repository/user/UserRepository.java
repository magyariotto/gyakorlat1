package com.github.magyariotto.repository.user;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserRepository {
    private static final Map<String, User> USERS = new HashMap<>();

    public void save(User user) {
        USERS.put(user.getUsername(), user);
    }

    public boolean usernameExists(String username){
        return USERS.containsKey(username);
    }
}
