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

        System.out.println();
        System.out.println("3.Feladat:");

        System.out.println("Ad meg a nevedet.");
        String nev = scanner.nextLine();

        System.out.println("Ad meg a nemedet.(ferfi/no)");
        String nem = scanner.nextLine();

        System.out.println("Ad meg az eletkorodat.");
        Integer kor = scanner.nextInt();

        if("ferfi".equals(nem)){
            if(kor < 20){
                System.out.println("Hello " + nev);
            }else{
                System.out.println("Good morning,Mr. " + nev);
            }
        }else if("no".equals(nem)){
            if(kor < 20){
                System.out.println("Hi,Miss. " + nev);
            }else{
                System.out.println("Good morning,Mr. " + nev);
            }
        }else{
            System.out.println("Szia " + nev + ", rosszul irtad be a nemedet.");
        }
    }
}