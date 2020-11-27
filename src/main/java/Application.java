import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        List lista = new ArrayList();
        lista.add("asd");
        lista.add("szoveg");
        lista.add(34);
        lista.add(new Object());

        for (Object o : lista){
            if (o instanceof String) {
                String s = (String) o;
            }else{
                throw new RuntimeException();
            }
        }

        List<String> lista2 = new ArrayList<String>();
        Map<String , String> map = new HashMap<>();
        lista2.add("szoveg");
        lista2.add("dfgsg");

        for (String o : lista2){
        }


    }

    private static void valami(List lista){

    }
}