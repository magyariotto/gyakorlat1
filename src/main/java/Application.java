import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elso szam");
        Integer szam1 = scanner.nextInt();

        System.out.println("Operandus");
        String operandus = new Scanner(System.in).nextLine();

        System.out.println("Masodik szam");
        Integer szam2 = scanner.nextInt();

        System.out.println("Ezt a muveletet fogjuk elvegezni:" + szam1 + " "+ operandus + " " + szam2);

        Double eredmeny = null;
        if("+".equals(operandus)){
            eredmeny = (double) szam1 + szam2;
        }else if("-".equals(operandus)){
            eredmeny = (double) szam1 - szam2;
        }else if("*".equals(operandus)){
            eredmeny = (double) szam1 * szam2;
        }else{
            System.out.println("Ismeretlen operandus:" + operandus);
        }

        System.out.println("Eredmeny: " + eredmeny);
        if(szam1 < 10){
            System.out.println("Az elso szam tiznel kisebb");
        }

        if(szam1 < 10 || szam2 < 10){
            System.out.println("Valamelyik szam kisebb mint 10");
        }

        System.out.println("Teszt &&:");
        if(hamis() && igaz()){
            System.out.println("Ennek nem szaba kiirodnia");
        }

        System.out.println("Teszt &:");
        if(igaz() & hamis()){
            System.out.println("Ennek nem szaba kiirodnia");
        }

        System.out.println("Teszt ||:");
        if(igaz() || hamis()){
            System.out.println("Az egyik feltetel igaz volt");
        }

        System.out.println("Teszt |:");
        if(igaz() | hamis()){
            System.out.println("Az egyik feltetel igaz volt");
        }

        System.out.println();
        System.out.println();
        System.out.println();

        Double eredmeny2 = null;
        switch (operandus){
            case "+":
                eredmeny2 = (double) szam1 + szam2;
                break;
            case "-":
                eredmeny2 = (double) szam1 - szam2;
                break;
            default:
                System.out.println("Ismeretlen operandus: " + operandus);
        }
        System.out.println("A switch eredmeny: " + eredmeny2);

        System.out.println();
        System.out.println("Ird be a vizsgalando szamot");
        String bemenet = new Scanner(System.in).nextLine();
        boolean hoszabbMintHarom = bemenet.length() < 3;
        String eredmeny3 =  hoszabbMintHarom ? "Hoszabb mint 3" : "Rovidebb mint 3";
        System.out.println(eredmeny3);

    }
    private static boolean igaz(){
        System.out.println("Az igaz meg lett hivva");
        return true;
    }
    private  static  boolean hamis(){
        System.out.println("A hamis meglett hivva");
        return  false;
    }
}