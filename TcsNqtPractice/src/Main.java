import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] test = {3,6,8,1,4,3};
        System.out.println(Code.largestNumber(test));
        System.out.println(Code.smallestNumber(test));
        Code.secondSmallestAndSecondLargest(test.clone());
        System.out.println(Arrays.toString(test));
        Code.isPalindrome(121);
        Code.isArmstrong(153);
        Code.countFrequencyAll(test);
        Code.rotateRight(test,3);
        System.out.println(Code.contiguousSubstringMaxSum(new int[]{1,2,3,4,5}));
        System.out.println(Code.reverseNumber(145879234));
        Code.decimalToBinary(16);
        Code.binaryToDecimal(10000);
        System.out.println(Code.isPrime(4));
        Code.primeNumbers(1,100);
        Code.palindromeNumbersRange(1,1000);
        Code.armstrongRange(1,1000);
        Code.lcm(6,8);
        System.out.println(Code.gcd(36,60));
        System.out.println(Code.isBalancedSum(new int[]{2,4,6,2,6,8}));
        System.out.println(Code.isBalancedAverage(new int[]{2,4,3,2}));
        Code.decimalToHexadecimal(255);

        Code.printSubString(new int[]{1,2,3,4});

        //Input section
        //Array
        //Scanner sc = new Scanner(System.in);
//        System.out.print("Enter the length of Array: ");
//        int n = sc.nextInt();
//        int[] array = new int[n];
//        for(int i=0;i<n;i++){
//            array[i] = sc.nextInt();
//        }
//        System.out.println(Arrays.toString(array));

        //String
//        while(sc.hasNext()){
//            System.out.println(sc.nextLine());
//        }
        //sc.close();

//        var ir = new InputStreamReader(System.in);
//        var reader = new BufferedReader(ir);
//        var string = new StringBuilder();
//        int n = 10;
//        var arr = new ArrayList<String>();
//        var count = 0;
//        while(count < n) {
//            try {
//                arr.addAll(List.of(reader.readLine().split("[ ]+")));
//                count=arr.size();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        System.out.println(arr);
    }
}