package com.github.magyariotto.dependency;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Parameter;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

public class BusinessLogicTest {
    private static final String ITEM = "item";
    private static final String PARAM = "param";

    private Provider provider;
    private Consumer consumer;

    private BusinessLogic underTest;

    @Before
    public void setUp() {
        provider = Mockito.mock(Provider.class);
        consumer = Mockito.mock(Consumer.class);
        underTest = new BusinessLogic(provider,consumer);
    }

    @Test
    public void process(){
        //GIVEN
        given(provider.get(PARAM)).willReturn(ITEM);
        //WHEN
        underTest.procces(PARAM);
        //THEN
        then(consumer).should().consume(ITEM);
    }
}