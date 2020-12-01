package com.github.magyariotto.dependency;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BusinessLogic {
private final Provider provider;
    private final Consumer consumer;

    public void procces(String param){
        String item = provider.get(param);
        consumer.consume(item);
    }
}
