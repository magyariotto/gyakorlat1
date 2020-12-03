package com.github.magyariotto.menu;

import com.github.magyariotto.read.ConsoleReader;
import com.github.magyariotto.repository.user.User;
import com.github.magyariotto.repository.user.UserRepository;
import com.github.magyariotto.util.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static java.util.Objects.isNull;

@Component
@RequiredArgsConstructor
@Slf4j
public class LoginMenu implements Menu {
    private final ConsoleReader consoleReader;
    private final UserRepository userRepository;
    private final AccountMenu accountMenu;
    private final Session session;

    @Override
    public void enterMenu() {
        System.out.println();
        System.out.println("Login");

        System.out.println("Username:");
        String username = consoleReader.readInput();

        System.out.println("Password:");
        String password = consoleReader.readInput();

        User user = userRepository.findByUsername(username);

        if (isNull(user)) {
            System.out.println("User not found.");
            return;
        }

        if (!password.equals(user.getPassword())) {
            System.out.println("Incorrect password.");
            return;
        }

        session.setUsername(username);
        System.out.println("Login succesful.");

        accountMenu.enterMenu();
    }
}
