import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        int[] intArray = new int[]{1, 2, 3, 4};

        System.out.println("Array by index");
        System.out.println(intArray[0]);
        System.out.println(intArray[1]);
        System.out.println(intArray[2]);
        System.out.println(intArray[3]);

        System.out.println();
        System.out.println("Array with for");
        for(int i = 0; i < intArray.length; i++){
            System.out.println(i + "-edik elem a tombben: " +intArray[i]);
        }

        System.out.println();
        System.out.println("Array enhanced with for");
        for(int elem : intArray){
            System.out.println("Elem: " + elem);
        }

        List<String> stringList = new ArrayList<>();
        stringList.add("Egy");
        stringList.add("Ketto");
        stringList.add("Harom");
        stringList.add("Negy");

        for(int i = 0; i<stringList.size(); i+=2){
            System.out.println(i + "-edik elem a listaban: " + stringList.get(i));
        }

        System.out.println();
        System.out.println("List with enhanced for");
        for(String elem : stringList){
            System.out.println("Elem: " + elem);
        }
        //**************************************************

        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(1, "Egy");
        integerStringMap.put(2, "Ketto");
        integerStringMap.put(3, "Harom");
        integerStringMap.put(4, "Negy");

        System.out.println();
        System.out.println("Map with enhanced for");
        for(Map.Entry<Integer, String> entry : integerStringMap.entrySet()){

            System.out.println("Kulcs: " + entry.getKey() + ", value: " +entry.getValue());
        }
    }
}