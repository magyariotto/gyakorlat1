package com.github.magyariotto.repository.user;

import lombok.*;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class User {
    private String username;
    private String password;
    private int balance;

    public void increaseBalance(int depositValue) {
        balance += depositValue;
    }

    public void withdrawBalance(int withdrawValue) {
        balance -= withdrawValue;
    }


    public void decreaseBalance(int transferValue) {
        balance -= transferValue;
    }
}
