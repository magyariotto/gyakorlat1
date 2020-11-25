package decorator;

import adapter.Auto;
import adapter.AutoMoso;

public class AutoMosoSzarito extends AutoMoso{
    public AutoMoso autoMoso;

    public AutoMosoSzarito(AutoMoso autoMoso){
        this.autoMoso = autoMoso;
    }
    @Override
    public void mos(Auto auto){
        autoMoso.mos(auto);
        System.out.println("Megszaritottam az autot.");
    }
}
