import exception.NemJarAMotorException;
import jarmu.Domper;

public class Application {
    public static void main(String[] args) {
        Domper domper = new Domper(100, 90);

        domper.felrakod(20);
        System.out.println("Felrakod: " + domper);

        //domper.motorBeindul();
        System.out.println("Beindul: " + domper);

        try {
            domper.elindul(10);
        } catch (NemJarAMotorException ex) {
            System.out.println("Nem jar a motor,de beiinditom most.");
            domper.motorBeindul();
            try {
                domper.elindul(10);
            } catch (NemJarAMotorException exception) {
                throw new RuntimeException("Nem sikerult elinditani a motort" + exception);
            }
        }

        System.out.println("Elindul: " + domper);

        try {
            domper.gyorsit(150);
        } catch (NemJarAMotorException | IllegalStateException e) {
            e.printStackTrace();
        } catch (IllegalAccessError e) {
            System.out.println("Ennivel nem tud menni,kicsit lasabban.");
            try {
                domper.gyorsit(50);
            } catch (NemJarAMotorException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Gyorsit: " + domper);

        domper.megall();
        System.out.println("Megall: " + domper);

        //domper.platoKinyit();
        System.out.println("Plato kinyit: " + domper);

        domper.lerakod();
        System.out.println("Lerakod: " + domper);

        domper.platoBecsuk();
        System.out.println("Plato Becsuk: " + domper);

        domper.motorMegall();
        System.out.println("Motor Megall: " + domper);
    }
}