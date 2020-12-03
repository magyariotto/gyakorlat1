package com.github.magyariotto.util;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
public class Session {
    @Setter
    @Getter
    private String username;
}
