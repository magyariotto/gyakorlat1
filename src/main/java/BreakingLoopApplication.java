public class BreakingLoopApplication {
    public static void main(String[] args){
        int counter = 0;
        while (true){
            counter++;

            System.out.println("Counter: " + counter);

            if (counter > 10){
                break;
            }
        }

        int counter2 = 0;
        while (counter2 < 100){
            counter2++;

            int maradek = counter2 % 2;
            if (maradek == 0){
                continue;
            }

            System.out.println("Counter2: " + counter2);
        }
    }
}
