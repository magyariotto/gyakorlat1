import java.util.*;

public class Application {
    public static void main(String[] args) {
        int[] tomb = new int[2];
        tomb[0] = 2;
        tomb[1] = 99;
        System.out.println(tomb[1]);

        List<Integer> lista = new ArrayList<>(2);
        lista.add(2);
        lista.add(85);
        lista.add(7);

        System.out.println(lista.get(2));

        int[][] ketDTomb = new int[2][2];

        ketDTomb[0][0] = 1;
        ketDTomb[0][1] = 2;
        ketDTomb[1][0] = 3;
        ketDTomb[1][1] = 4;

        System.out.println(Arrays.toString(ketDTomb[1]));

        Map<String,Integer> map = new HashMap<>();
        map.put("kulcs1",12);
        map.put("kulcs2",24);
        System.out.println(map);
        System.out.println(map.get("kulcs2"));



    }
}