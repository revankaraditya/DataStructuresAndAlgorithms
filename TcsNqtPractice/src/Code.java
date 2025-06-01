import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Code {
    public static int smallestNumber(int[] array){
        var small = array[0];
        for(var i:array)
            if(i<small)
                small=i;
        return small;
//        Arrays.sort(array);
//        return array[0];
    }
    public static int largestNumber(int[] array){
        var large = array[0];
        for(var i:array)
            if(i>large)
                large=i;
        return large;
//        Arrays.sort(array);
//        return array[array.length-1];
    }
    public static void secondSmallestAndSecondLargest(int[] array){
        Arrays.sort(array);
        System.out.println("Second smallest = " + array[1] + "\nSecond largest = " + array[array.length-2]);
    }

    public static void isPalindrome(int number){
        int reverse = 0;
        int q = number;
        while(q>0){
            var r = q%10;
            q/=10;
            reverse=(reverse*10)+r;
        }
        System.out.println(reverse==number);
    }
    public static void isArmstrong(int number){
        //wrong
        int res = 0;
        int q=number;
        while(q>0){
            var r = q%10;
            q/=10;
            res = res + r*r*r;
        }
        System.out.println(res==number);
    }
    public static void countFrequencyAll(int[] array){
        var map = new HashMap<Integer,Integer>();
        for(int i:array){
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        System.out.println(map);
    }
    public static void rotateRight(int[] array, int k){
        int[] res = new int[array.length];
        int j=0;
        for(int i=k;i<array.length;i++){
            res[j++]=array[i];
        }
        for(int i=0;i<k;i++){
            res[j++]=array[i];
        }
        System.out.println(Arrays.toString(res));
    }

    public static int contiguousSubstringMaxSum(int[] array){
        int max = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++)
            for(int j=0;j<=i;j++)
                max = Math.max(max, arraySum(array, j, i));
        return max;
    }
    public static int arraySum(int[] array,int start,int end){
        int sum = 0;
        for(int i=start;i<=end;i++)
            sum+=array[i];
        return sum;
    }
    public static int reverseNumber(int number){
        String s = Integer.toString(number);
        var result = new StringBuilder(s);
        return Integer.parseInt(result.reverse().toString());
    }
    public static void decimalToBinary(int number){
        var result = new StringBuilder();
        while(number>0){
            var rem = number%2;
            result.append(rem);
            number = number/2;
        }
        System.out.println(result.reverse().toString());
    }
    public static void binaryToDecimal(int binary){
        char[] array = Integer.toString(binary).toCharArray();
        var decimal=0;
        System.out.println(Arrays.toString(array));
        for(int i=0;i<array.length;i++){
            decimal+=Math.pow(2,(array.length-1)-i)*Character.getNumericValue(array[i]);
        }
        System.out.println(decimal);
    }
    public static boolean isPrime(int number){
        if(number==1)
            return false;
        for(int i=2;i<=Math.sqrt(number);i++){
            if(number%i==0)
                return false;
        }
        return true;
    }
    public static void primeNumbers(int from,int to){
        for(int i=from;i<=to;i++){
            if(isPrime(i))
                System.out.println(i + " is Prime");
        }
    }
    public static void palindromeNumbersRange(int from,int to){
        for(int i=from;i<=to;i++){
            var s = new StringBuilder(Integer.toString(i));
            s.reverse();
            if(i==Integer.parseInt(s.toString())){
                System.out.println(i + " is Palindrome");
            }
        }
    }
    public static void armstrongRange(int from,int to){
        for(int i=from;i<=to;i++){
            char[] array = Integer.toString(i).toCharArray();
            int sum = 0;
            for(char c:array){
                sum += Math.pow(Character.getNumericValue(c),array.length);
            }
            if(sum==i)
                System.out.println(i + " is Armstrong");
        }
    }
    public static int gcd(int a, int b){
        var s = Math.min(a,b);
        var l = Math.max(a,b);
        for(int i=s;i>1;i--)
            if(s%i==0 && l%i==0)
                return i;
        return 1;
    }
    public static boolean isBalancedSum(int[] array){
        var rightSum=0;
        for(int i: array)
            rightSum+=i;
        var leftSum=0;
        for(int i:array){
            leftSum+=i;
            rightSum-=i;
            if(leftSum==rightSum)
                return true;
        }
        return false;
    }
    public static boolean isBalancedAverage(int[] array){
        var rightSum=0;
        for(int i: array)
            rightSum+=i;

        var leftSum=0;
        for(int i=1;i<=array.length;i++){
            leftSum+=array[i-1];
            rightSum-=array[i-1];
            if(avg(leftSum,i)==avg(rightSum,array.length-i))
                return true;
        }
        return false;
    }
    public static float avg(int sum,int no){
        return (float)sum/no;
    }
    public static void lcm(int a,int b){
        System.out.println(a*b/gcd(a,b));
    }
    public static void decimalToHexadecimal(int number){
        System.out.println(Integer.toHexString(number).toUpperCase());
    }

    public static void printSubString(int[] array){
        var set = new HashSet<ArrayList<Integer>>();
        for(int i=0;i<array.length;i++){
            for(int j=0;j<=i;j++){
                set.add(trimArray(array,j,i));
            }
        }
        System.out.println(set);
        System.out.println(set.size());
    }
    public static ArrayList<Integer> trimArray(int[] array, int a, int b){
        var arr = new ArrayList<Integer>();
        for(int i=a;i<=b;i++){
            arr.add(array[i]);
        }
        return arr;
    }
}
