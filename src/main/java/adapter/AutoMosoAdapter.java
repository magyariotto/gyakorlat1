package adapter;

public class AutoMosoAdapter {
    private AutoMoso autoMoso;

    public AutoMosoAdapter(AutoMoso autoMoso){
        this.autoMoso = autoMoso;
    }
    public void mos(Kocsi kocsi){
        Auto auto = new Auto(kocsi.getMarka());
        autoMoso.mos(auto);
    }
}
