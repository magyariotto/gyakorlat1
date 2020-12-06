package com.github.magyariotto.jarmu;

import lombok.Data;

@Data
public class Domper {
    private final int kapacitas;
    private final int maxSebesseg;

    private boolean jarAMotor;
    private boolean platoNyitva;
    private int sebesseg;
    private int rakomany;

    public Domper(int kapacitas, int maxSebesseg) {
        this.kapacitas = kapacitas;
        this.maxSebesseg = maxSebesseg;
        System.out.println("A Domper elkeszult: " + this);
    }

    public void motorBeindul() {
        jarAMotor = true;
    }

    public void motorMegall() {
        jarAMotor = false;
    }

    public void platoKinyit() {
        if (sebesseg != 0) {
            throw new IllegalStateException("A Domper halad. Sebesseg: " + sebesseg);
        }
        platoNyitva = true;
    }

    public void platoBecsuk() {
        platoNyitva = false;
    }

    public void elindul(Integer sebesseg) throws NemJarAMotorException {
        if (this.sebesseg != 0) {
            throw new IllegalStateException("A Domper halad. Sebesseg: " + sebesseg);
        }
        if (platoNyitva) {
            throw new IllegalStateException("A plato nyitva.Zard be.");
        }
        if (!jarAMotor) {
            throw new NemJarAMotorException();
        }
        if (sebesseg > maxSebesseg) {
            throw new IllegalArgumentException("Ez a jarmu nem tud ilyen gyorsan menni,a max sebessege: " + maxSebesseg);
        }
        this.sebesseg = sebesseg;
    }

    public void megall() {
        sebesseg = 0;
    }

    public void gyorsit(Integer sebesseg) throws NemJarAMotorException {
        int ujSebesseg = this.sebesseg + sebesseg;
        if (!jarAMotor) {
            throw new NemJarAMotorException();
        }
        if (platoNyitva) {
            throw new IllegalStateException("A plato nyitva.");
        }
        if (ujSebesseg > maxSebesseg) {
            throw new IllegalArgumentException("Ez a jarmu nem tud ennyivel menni,a max sebesseg: " + maxSebesseg);
        }
        this.sebesseg += sebesseg;
    }

    public void felrakod(Integer rakomany) {
        int ujRakomany = this.rakomany + rakomany;

        if (ujRakomany > kapacitas) {
            throw new TulSokRakomanyException(ujRakomany + " meghaladja" +
                    " a maximum kapacitast.");
        }

        this.rakomany += rakomany;
    }

    public void lerakod() {
        if (!platoNyitva) {
            throw new IllegalStateException("A plato nincs nyitva.");
        }
        rakomany = 0;
    }

    @Override
    public String toString() {
        return "["
                + "Kapacitas: " + kapacitas
                + ",jarAMotor: " + jarAMotor
                + ",platoNyitva: " + platoNyitva
                + ",Sebesseg: " + sebesseg
                + ",Rakomany: " + rakomany
                + "]";
    }
}

