import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

        //First non-repeating character
        CharFinder finder = new CharFinder();
        var ch = finder.findFirstNonRepeatingChar("aditya revankar");
        System.out.println(ch);

        //Set implementation using hashset
        Set<Integer> set = new HashSet<>();
        int[] numbers = {1,2,2,4,3,4,5,6,7,8,0,0,0};
        for(var item : numbers)
            set.add(item);
        System.out.println(set);

        //First repeating character
        CharFinder obj = new CharFinder();
        var c = obj.firstRepeatingCharacter("sakshi");
        System.out.println(c);

        //hashcode
        String ab = "orange";
        System.out.println(ab.hashCode());

        //Hashtable
        System.out.println("\n\nHashTable implementation");
        HashTable hashtable = new HashTable();
        hashtable.put(1,"aditya");
        hashtable.put(2,"sakshi");
        hashtable.put(8,"anju");
        hashtable.put(13,"anjali");
        System.out.println(hashtable.get(13));
        hashtable.remove(8);
        System.out.println(hashtable.get(8));
    }
    public static int hash(int number){
        return number%100;
    }
    public static int hash(String key){
        int hash=0;
        for(var ch: key.toCharArray())
            hash+=ch;
        return hash%100;
     }
}