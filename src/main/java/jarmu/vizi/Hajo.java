package jarmu.vizi;

import jarmu.Jarmu;
import jarmu.Szinek;

public class Hajo extends ViziJarmu implements Jarmu {
    public Integer sebesseg = 0;

    public Hajo(Szinek color){
        this.color = color;
        this.vitorlakSzama = 1;
    }

    public void elindul(Integer mertek){sebesseg = mertek;}

    @Override
    public void gyorsit(Integer mertek) {
        super.sebesseg += mertek;
    }
}
