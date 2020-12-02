package com.github.magyariotto.menu;

import com.github.magyariotto.read.ConsoleReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.github.magyariotto.util.Constats.*;

@RequiredArgsConstructor
@Component
public class MainMenu implements Menu {
    private final ConsoleReader consoleReader;
    private final RegistrationMenu registrationMenu;

    @Override
    public void enterMenu() {
        String input;

        do {
            System.out.println();
            System.out.println("Main Menu");
            System.out.println("Commands:");
            System.out.println("add - Create new user.");
            System.out.println("login - Login to user.");
            System.out.println("exit - Exit application.");
            System.out.println("Choose one command from above:");

            input = consoleReader.readInput();
            switch (input) {
                case MAIN_MENU_ADD_USER_OPTION:
                registrationMenu.enterMenu();
                    break;
                case MAIN_MENU_LOGIN_USER_OPTION:
                    break;
                case EXIT_OPTION:
                default:
                    System.err.println("Unknown command");
            }
        } while (!EXIT_OPTION.equals(input));
    }
}
