package com.github.magyariotto.service;

import com.github.magyariotto.read.IntegerValidationReader;
import com.github.magyariotto.read.ValidationReader;
import com.github.magyariotto.repository.user.User;
import com.github.magyariotto.repository.user.UserRepository;
import com.github.magyariotto.validation.PositivNumberValidation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@RunWith(MockitoJUnitRunner.class)
public class DepositServiceTest {
    private static final int DEPOSIT_VALUE = 100;

    @Mock
    private IntegerValidationReader integerValidationReader;

    @Mock
    private ValidationReader validationReader;

    @Mock
    private PositivNumberValidation positivNumberValidation;

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private DepositService underTest;

    @Mock
    public User user1;

    @Test
    public void deposit_shouldCancelDeposit_whenDepositValueIsZero(){
        //GIVEN
        given(integerValidationReader.readNumber(positivNumberValidation))
                .willReturn(0);
        //WHEN
        underTest.deposit(user1);
        //THEN
        then(user1).should().increaseBalance(0);
        then(user1).shouldHaveNoMoreInteractions();
        then(userRepository).should().save(user1);
    }

    @Test
    public void deposit_executeDeposit(){
        //GIVEN
        given(integerValidationReader.readNumber(positivNumberValidation))
                .willReturn(DEPOSIT_VALUE);
        //WHEN
        underTest.deposit(user1);
        //THEN
        then(integerValidationReader).should()
                .readNumber(positivNumberValidation);
        then(user1).should().increaseBalance(DEPOSIT_VALUE);
        then(userRepository).should().save(user1);
    }
}