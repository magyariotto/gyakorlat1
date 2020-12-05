package com.github.magyariotto.repository.user;

import com.github.magyariotto.repository.DatabaseConnection;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserRepository {
    private static final String SAVE_SQL = "INSERT INTO public.bank_user (username, password, balance) VALUES('%s', '%s', '%s')";
    private static final String FIND_BY_USERNAME_SQL = "SELECT username, password, balance FROM public.bank_user WHERE username='%s'";
    private static final String MODIFY_SQL = "UPDATE public.bank_user SET password='%s', balance='%s' WHERE username='%s'";

    private final DatabaseConnection databaseConnection;
    private final UserMapper userMapper;

    public void save(User user) {
        if(usernameExists(user.getUsername())){
            String sql = String.format(MODIFY_SQL, user.getPassword(),user.getBalance(),user.getUsername());
            log.info("Sql statement for modifyng user: {}", sql);
            databaseConnection.execute(sql);
        }else {
            String sql = String.format(SAVE_SQL, user.getUsername(), user.getPassword(), user.getBalance());
            log.info("SQL statement for saving user: {}", sql);
            databaseConnection.execute(sql);
        }
    }

    public boolean usernameExists(String username) {
        return !isNull(findByUsername(username));
    }

    public User findByUsername(String username) {
        String sql = String.format(FIND_BY_USERNAME_SQL,username);
        log.info("SQL statement for query user by username: {}", sql);
        return databaseConnection.query(sql,userMapper);
    }
}
