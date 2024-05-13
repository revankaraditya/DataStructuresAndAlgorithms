import java.util.HashMap;
import java.util.Map;

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
}
