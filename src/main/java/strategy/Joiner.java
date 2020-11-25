package strategy;

import java.util.List;

public class Joiner implements Strategy {
    @Override
    public String osszefuz(List<String> darabok) {
        return String.join("", darabok);
    }
}
