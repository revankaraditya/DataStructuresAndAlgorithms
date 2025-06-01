import java.util.*;

public class Programs {
    /*
    1.	Rearrange Array in Increasing-Decreasing Order
    Description: Given an array, rearrange it so the first half is sorted in ascending order and the second half in descending order.
     */
    public static void rearrangeArray(int[] array){
        Arrays.sort(array);
        int len = array.length;
        for(int i=len/2,j=len-1;i<j;i++,j--){
//            int temp = array[i];
//            array[i] = array[j];
//            array[j] = temp;
            array[i] = array[i]+array[j];
            array[j] = array[i]-array[j];
            array[i] = array[i]-array[j];
        }
        System.out.println(Arrays.toString(array));
    }

    /*
    2.	Find the Second Smallest and Second Largest Element in an Array
    Description: Identify both the second smallest and second largest elements by iterating through the array.
     */
    public static void secondSmallestAndLargest(int[] array){
        Arrays.sort(array);
        System.out.println("Second Smallest = " + array[1] + "\nSecond Largest = "+ array[array.length-2]);
    }
    /*
    3.	Sort Elements of an Array by Frequency
    Description: Sort array elements based on their frequency, with elements of the same frequency retaining their order of first occurrence.
     */
    public static void sortByFrequency(int[] array){
        var map = new HashMap<Integer,Integer>();
        for(int i:array){
            if(map.containsKey(i)){
               map.put(i,map.get(i)+1);
            }
            else{
                map.putIfAbsent(i,1);
            }
        }
        System.out.println(map);
    }

    /*
    4.	Rotate Array by K Elements
    Description: Rotate an array by k positions to the right, wrapping elements that go beyond the end of the array to the beginning.
     */
    public static void rotateRight(int[] array,int k){
        for(int i=0;i<k%array.length;i++){
            int temp = array[array.length-1];
            for(int j=array.length-1;j>0;j--){
                array[j] = array[j-1];
            }
            array[0] = temp;
        }
        System.out.println(Arrays.toString(array));
    }
    /*
    5.	Remove Duplicates from an Unsorted Array
    Description: Remove duplicates in an unsorted array and return the array with unique elements.
     */
    public static void removeDuplicates(int[] array){
        var set = new HashSet<Integer>();
        for(int i:array){
            set.add(i);
        }
        System.out.println(Arrays.toString(set.toArray()));
    }
    /*
    6.	Check if Array is Subset of Another Array
    Description: Given two arrays, check if the second array is a subset of the first by verifying that all elements of the second array appear in the first array.
     */
    public static boolean isSubset(int[] a,int[] b){
        //Check if b is a subset of a
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i]==b[j]){
                i++;
                j++;
            }
            else{
                i++;
                j=0;
            }
        }
        return j==b.length;
    }
    /*
    7.	Find All Non-Repeating Elements in an Array
    Description: Given an array, find all elements that appear only once and return them.
     */
    public static void removeRepeating(int[] array){
        var set  = new HashSet<Integer>();
        for(int i:array)
            if(!set.contains(i)){
                set.add(i);
                System.out.print(i + ", ");
            }
        System.out.println();
    }
    /*
    8.	Check if a Number is Armstrong
    Description: Determine if a number is an Armstrong number, where the sum of its digits each raised to the power of the number of digits equals the number itself.
     */
    public static boolean isArmstrong(int number){
        char[] numberArray = Integer.toString(number).toCharArray();
        int power = numberArray.length;
        int sum=0;
        for(char c:numberArray){
            sum += Math.pow(Character.getNumericValue(c),power);
        }
        return sum==number;
    }
    /*
    9.	Prime Numbers in a Given Range
    Description: Print all prime numbers within a specified range [a, b].
     */
    public static void primeRange(int a,int b){
        for(int i=a;i<=b;i++){
            var isPrime = true;
            for(int j=2;j<=Math.sqrt(i);j++){
                if(i%j==0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime && i>=2)
                System.out.print(i+ ", ");
        }
        System.out.println();
    }
    /*
    10.	Print Fibonacci Series up to Nth Term
    Description: Print the Fibonacci series up to the Nth term, where each term is the sum of the previous two terms.
     */
    public static void printFibonacci(int n){
        int a = 0;
        int b = 1;
        System.out.print(a +", "+b+", ");
        for(int i=0;i<n-1;i++){
            int c = a+b;
            System.out.print(c + ", ");
            a=b;
            b=c;
        }
        System.out.println();
    }
    public static int printFibonacciRecursion(int n){
        if(n<=1)
            return n;
        return printFibonacciRecursion(n-1)+printFibonacciRecursion(n-2);
    }
    /*
    11.	Check if a Number is a Strong Number
    Description: Determine if a number is a Strong Number, where the sum of the factorials of its digits equals the number itself.
     */
    public static int factorial(int n){
        if(n<1)
            return 1;
        return n*factorial(n-1);
    }
    public static boolean isStrongNumber(int number){
        char[] numArray = Integer.toString(number).toCharArray();
        int factSum = 0;
        for(int i: numArray)
            factSum+=factorial(Character.getNumericValue(i));
        return factSum==number;
    }
    /*
    12.	Find GCD of Two Numbers
    Description: Calculate the greatest common divisor (GCD) of two numbers using the Euclidean algorithm.
     */
    public static void gcd(int a,int b){
        System.out.println((a*b)/lcm(a,b));
    }
    public static int lcm(int a,int b){
        if()
    }

}
