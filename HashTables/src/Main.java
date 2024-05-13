import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*Map<Integer,String> map = new HashMap<>();
        map.put(1,"A");
        map.put(2,"B");
        map.put(3,"C");
        System.out.println(map);
        for(var item: map.keySet())
            System.out.println(item);
        for(var item:map.entrySet())
            System.out.println(item);
        System.out.println(map.containsKey(4));
        System.out.println(map.containsValue("A"));
         */

        CharFinder finder = new CharFinder();
        var ch = finder.findFirstNonRepeatingChar("aditya revankar");
        System.out.println(ch);
    }
}