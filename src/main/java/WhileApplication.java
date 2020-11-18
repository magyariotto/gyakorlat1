import java.util.Random;

public class WhileApplication {
    public static  void main(String[] args){
        System.out.println("While");
        double szam = 0;
        while (szam < 0.8){
            System.out.println("Szam: " + szam);
            szam = new Random().nextDouble();
            System.out.println("Uj Szam: " +szam);
        }

        System.out.println();
        System.out.println("Do...While");
        double szam2;
        do {
            szam2 = new Random().nextDouble();
            System.out.println("Szam2: " + szam2);
        } while (szam2 < 0.8);
    }
}
