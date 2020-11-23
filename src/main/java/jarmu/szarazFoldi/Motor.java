package jarmu.szarazFoldi;

import jarmu.Szinek;

public class Motor extends SzarazfoldiJarmu{
    public Motor(Szinek color){
        this.color = color;
        this.kerekekSzama = 2;
    }

    @Override
    public void gyorsit(Integer mertek) {
        sebesseg += mertek;
    }
}
