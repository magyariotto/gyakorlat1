import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.Feladat:");
        System.out.println("Irj be egy mondatot,es megmondom a leghoszabb szot belole.");
        String szoveg = scanner.nextLine();
        String[] darabok = szoveg.split(" ");
        Integer szavakSzama = darabok.length;
        Integer valtozo = 0;
        Integer leghosszabbSzo = 0;

        for(int i = 0; i< szavakSzama; i++){
            Integer szo = darabok[i].length();
            if( szo > leghosszabbSzo){
                leghosszabbSzo = szo;
                valtozo = i;
            }
        }
        System.out.println(darabok[valtozo]);

        System.out.println();
        System.out.println("2. Feladat:");
        System.out.println("Kerlek adj meg egy szoveget,es megforditom;");

        String szoveg2 = scanner.nextLine();
        String[] tomb = szoveg2.split("");
        Integer tombHossza = tomb.length;

        for(int i=0; i<tombHossza; i++){
            System.out.print(tomb[tombHossza-i-1]);
        }
    }
}