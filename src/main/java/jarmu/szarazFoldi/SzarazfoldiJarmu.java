package jarmu.szarazFoldi;

import jarmu.Jarmu;
import jarmu.Szinek;

public abstract class SzarazfoldiJarmu implements Jarmu {
    public static final int Alapsebesseg = 50;

    public Szinek color;
    protected Integer sebesseg = 0;
    public Integer kerekekSzama;

    public final void elindul(){
        sebesseg = Alapsebesseg;
    }

    public abstract void gyorsit(Integer mertek);

    @Override
    public void megall() {
        sebesseg = 0;
    }
    public Integer getSebesseg(){
        return sebesseg;
    }
}
