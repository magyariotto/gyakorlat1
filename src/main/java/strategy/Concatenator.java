package strategy;

import java.util.List;

public class Concatenator implements Strategy {
    @Override
    public String osszefuz(List<String> darabok) {
        String result = "";
        for (String darab : darabok) {
            result += darab;
        }
        return result;
    }
}
