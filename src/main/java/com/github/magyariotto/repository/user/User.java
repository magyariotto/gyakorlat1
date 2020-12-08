package com.github.magyariotto.repository.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Entity
@Table(schema = "bank", name = "bank_user")
public class User {
    @Id
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
