import jarmu.szarazFoldi.Auto;
import jarmu.szarazFoldi.Motor;
import jarmu.szarazFoldi.SzarazfoldiJarmu;
import jarmu.szarazFoldi.Szinek;

public class Application {
    public static void main(String[] args){
        Auto auto1 = new Auto(Szinek.Kek);
        SzarazfoldiJarmu motor1 = new Motor(Szinek.Sarga);
        motor1.color = Szinek.Sarga;

        System.out.println(auto1.color.getErtek());
        System.out.println(motor1.color);

        System.out.println("Az autonak " + auto1.kerekekSzama + " kereke van");

        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.elindul(20);
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.gyorsit(400);
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        auto1.megall();
        System.out.println("Ennyivel megy az auto: " + auto1.getSebesseg());
        System.out.println();


        System.out.println("Ennyivel megy a motor: " + motor1.getSebesseg());
        motor1.elindul();
        System.out.println("Ennyivel megy a motor: " + motor1.getSebesseg());
        motor1.megall();
        System.out.println("Ennyivel megy a motor: " + motor1.getSebesseg());
    }
}
