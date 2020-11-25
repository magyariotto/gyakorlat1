package proxy;

import adapter.Auto;
import adapter.AutoMoso;

public class AutoMosoProxy {
    private AutoMoso autoMoso;
    private Integer mososzerMennyiseg = 0;

    public void mos(Auto auto) {
        if (autoMoso == null) {
            System.out.println("Nincs automosonk,vegyunk egyet!");
            autoMoso = new AutoMoso();
        }

        if (mososzerMennyiseg == 0) {
            utantolt();
        }

        autoMoso.mos(auto);

        mososzerMennyiseg--;
        System.out.println("Mosas kesz, " + mososzerMennyiseg + "mososzer maradt.");
    }

    private void utantolt() {
        System.out.println("Utantoltes...");
        mososzerMennyiseg = 5;
    }
}
