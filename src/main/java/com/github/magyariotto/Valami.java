package com.github.magyariotto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true, exclude = "asd")
@EqualsAndHashCode
public class Valami {
    private String ertek;
    private Boolean asd;

    public Valami(){

    }
}
