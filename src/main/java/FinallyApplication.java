public class FinallyApplication {
    public static void main(String[] args) {
        try {
            if (true) {
                throw new RuntimeException("Hiba vagyok.");
            }
            System.out.println("Nem fogok kiirodni,mert elotem hiba lett dobva.");
        } catch (RuntimeException e) {
            System.out.println("Elkaptam a hibat: " + e.getMessage());
        } finally {
            System.out.println("En mindig lefutok");
        }

        try {
            if (true) {
                throw new RuntimeException("Hiba vagyok");
            }
            System.out.println("Nem fogok kiirodni,mert elotem hiba lett dobva");
        } finally {
            System.out.println("Mondtam,hogy en mindig lefutok");
        }
    }
}
