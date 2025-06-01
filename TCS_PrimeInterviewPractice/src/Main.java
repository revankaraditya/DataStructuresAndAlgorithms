import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] test = new int[]{1,5,7,3,8,22,5,77,99,12,34,56};
        System.out.println("Array: " + Arrays.toString(test));
        Programs.rearrangeArray(test.clone());
        Programs.secondSmallestAndLargest(test.clone());
        Programs.sortByFrequency(test.clone());
        Programs.rotateRight(test.clone(),10);
        Programs.removeDuplicates(test.clone());
        System.out.println(Programs.isSubset(test.clone(),new int[]{22,5,77,99,12,34,56}));
        Programs.removeRepeating(test.clone());
        System.out.println(Programs.isArmstrong(2));
        Programs.primeRange(0,100);
        Programs.printFibonacci(10);
        System.out.println(Programs.printFibonacciRecursion(10));
        System.out.println(Programs.isStrongNumber(145));
    }
}