package com.github.magyariotto.repository.user;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    boolean existsByUsername(String username);

    User findByUsername(String username);

    List<User> findByBalanceLessThan(int balance);
}
