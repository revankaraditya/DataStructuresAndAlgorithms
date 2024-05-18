import java.sql.Array;
import java.util.*;

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


        //Exercise
        //MostFrequent
        Exercise e = new Exercise();
        var res1 = e.mostFrequent(new int[]{1,2,3,2,2});
        System.out.println(res1);
        //countPairsWithDifference
        int[] a = {1,7,5,9,2,12,3};
        var res2 = e.countPairsWithDiff(a,2);
        System.out.println(res2);
        //TwoSum
        int[] b = {2, 7, 11, 15};
        int[] res3 = e.twoSum(b,26);
        System.out.println(Arrays.toString(res3));
        //Hashtable with linear probing
        HashTableLinearProbing ht = new HashTableLinearProbing(4);
        ht.put(10,"A");
        ht.put(20,"B");
        ht.put(30,"C");
        System.out.println(ht.get(20));
        ht.remove(10);
        System.out.println(ht);
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