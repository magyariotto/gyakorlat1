package facade;

import adapter.Auto;
import adapter.AutoMoso;
import adapter.AutoMosoAdapter;
import adapter.Kocsi;
import decorator.AutoMosoSzarito;

public class AutoMosoFacade {
    private AutoMoso autoMoso = new AutoMoso();
    private AutoMosoSzarito autoMosoSzarito = new AutoMosoSzarito(autoMoso);
    private AutoMosoAdapter autoMosoAdapter = new AutoMosoAdapter(autoMoso);

    public void kocsiMosas(Kocsi kocsi){
        autoMosoAdapter.mos(kocsi);
    }

    public void autoMosas(Auto auto){
        autoMoso.mos(auto);
    }

    public void autoMosasEsSzaritas(Auto auto){
        autoMosoSzarito.mos(auto);
    }
}
