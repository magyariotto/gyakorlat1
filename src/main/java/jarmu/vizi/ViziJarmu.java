package jarmu.vizi;

import jarmu.Jarmu;
import jarmu.Szinek;

public abstract class ViziJarmu implements Jarmu {
    public static final int Alapsebesseg = 100;

    public Szinek color;
    protected Integer sebesseg = 0;
    public Integer vitorlakSzama;

    public final void elindul(){sebesseg = Alapsebesseg;}

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall(){ sebesseg = 0;}
    public Integer getSebesseg(){return sebesseg;}
}
