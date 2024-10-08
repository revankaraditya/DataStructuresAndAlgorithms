import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CharFinder {
    public char findFirstNonRepeatingChar(String str){
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = str.toCharArray();
        for(char ch:charArray){
            /*if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
             */
            var count = map.containsKey(ch) ? map.get(ch) : 0;
            map.put(ch,count+1);
        }
        //System.out.println(map);
        for(char ch:charArray){
            if(map.get(ch)==1){
                //System.out.println(ch);
                return ch;
            }
        }
        return Character.MIN_VALUE;
    }
    public char firstRepeatingCharacter(String str){
        char[] charArray = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for(char ch:charArray){
            if(set.contains(ch))
                return ch;
            set.add(ch);
        }
        return Character.MIN_VALUE;
    }
}
