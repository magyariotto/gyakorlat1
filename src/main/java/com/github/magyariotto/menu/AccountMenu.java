package com.github.magyariotto.menu;

import com.github.magyariotto.read.ConsoleReader;
import com.github.magyariotto.repository.user.User;
import com.github.magyariotto.repository.user.UserRepository;
import com.github.magyariotto.service.DepositService;
import com.github.magyariotto.service.TransferService;
import com.github.magyariotto.service.WithdrawService;
import com.github.magyariotto.util.Session;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static com.github.magyariotto.util.Constats.*;

@Component
@RequiredArgsConstructor
public class AccountMenu implements Menu {
    private final Session session;
    private final ConsoleReader consoleReader;
    private final UserRepository userRepository;
    private final DepositService depositService;
    private final WithdrawService withdrawService;
    private final TransferService transferService;

    @Override
    public void enterMenu() {
        String username = session.getUsername();

        String input;

        do {
            User user = userRepository.findByUsername(username);
            System.out.println();
            System.out.println("Hello, " + username);
            System.out.println("Main Menu");
            System.out.println("Commands:");
            System.out.println("balance - Check actual balance.");
            System.out.println("deposit - Deposit.");
            System.out.println("withdraw - Withdraw.");
            System.out.println("transfer - Transfer.");
            System.out.println("logout - Exit application.");
            System.out.println("Choose one command from above:");

            input = consoleReader.readInput();

            switch (input) {
                case ACCOUNT_MENU_BALANCE_OPTION:
                    System.out.println();
                    System.out.println("Your balance is: " + user.getBalance());
                    break;
                case ACCOUNT_MENU_DEPOSIT_OPTION:
                    depositService.deposit(user);
                    break;
                case ACCOUNT_MENU_WITHDRAW_OPTION:
                    withdrawService.withdraw(user);
                    break;
                case ACCOUNT_MENU_TRANSFER_OPTION:
                    transferService.transfer(user);
                    break;
                case ACCOUNT_MENU_LOGOUT_USER_OPTION:
                    break;
                default:
                    System.err.println("Unknown command");
            }
        } while (!ACCOUNT_MENU_LOGOUT_USER_OPTION.equals(input));
    }
}
