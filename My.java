import java.util.Scanner;

public class My{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Number one");
		Integer elsoSzam = scanner.nextInt();
		
		System.out.println("Number two");
		Integer masodikSzam = scanner.nextInt();
		
		Integer eredmeny = elsoSzam + masodikSzam;
		
		System.out.println("Eredmeny:" + eredmeny);
	}
}