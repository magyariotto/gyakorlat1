package com.github.magyariotto;

import org.apache.commons.lang3.StringUtils;

public class Application {
    public static void main(String[] args) {
        boolean result = StringUtils.isNoneBlank("afe");
        System.out.println("Eredmeny: " + result);
    }
}