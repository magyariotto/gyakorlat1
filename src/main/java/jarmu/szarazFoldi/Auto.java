package jarmu.szarazFoldi;

import jarmu.Szinek;

public class Auto extends SzarazfoldiJarmu{
    public Integer sebesseg = 0;

    public Auto(Szinek color){
        this.color = color;
        this.kerekekSzama = 4;
    }

    public void elindul(Integer mertek){
        sebesseg = mertek;
    }

    public void elindul(short mertek){
        sebesseg =(int) mertek;
    }

    @Override
    public void gyorsit(Integer mertek) {
        super.sebesseg += mertek;
    }
}
