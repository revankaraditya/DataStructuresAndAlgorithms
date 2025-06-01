import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        System.out.println(toDecimal("MCMXCIV"));
    }
    public static int toDecimal(String roman){
        var map = new HashMap<Character,Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int sum = 0;
        int len = roman.length();
        for(int i=0;i<len-1;i++){
            if(roman.charAt(i)=='I' && (roman.charAt(i+1)=='V' ||roman.charAt(i+1)=='X'))
                sum-=1;
            else if(roman.charAt(i)=='X' && (roman.charAt(i+1)=='L' ||roman.charAt(i+1)=='C'))
                sum-=10;
            else if(roman.charAt(i)=='C' && (roman.charAt(i+1)=='D' ||roman.charAt(i+1)=='M'))
                sum-=100;
            else
                sum+=map.get(roman.charAt(i));
        }
        return sum+map.get(roman.charAt(len-1));
    }
}