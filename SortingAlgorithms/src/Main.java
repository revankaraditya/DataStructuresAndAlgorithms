import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Comparison sorting
        int[] input1 = {6,5,4,3,2,1};
        Algorithms algo = new Algorithms();
        algo.bubbleSort(input1);
        System.out.println(Arrays.toString(input1));
        int[] input2 = {6,5,4,3,2,1};
        algo.selectionSort(input2);
        System.out.println(Arrays.toString(input2));
        int[] input3 = {6,5,4,3,2,1};
        algo.insertionSort(input3);
        System.out.println(Arrays.toString(input3));
        int[] input4 = {6,5,4,3,2,1};
        algo.mergeSort(input4);
        System.out.println(Arrays.toString(input4));
        int[] input5 = {15,6,3,1,22,10,13};
        algo.quickSort(input5);
        System.out.println(Arrays.toString(input5));

        //Non-comparison sorting
        int[] input6 = {15,6,3,1,22,10,13};
        algo.countingSort(input6,22);
        System.out.println(Arrays.toString(input6));
        int[] input7 = {15,6,3,1,22,10,13};
        algo.bucketSort(input7,5);  //be cautious on number of buckets value
        System.out.println(Arrays.toString(input7));
    }
}