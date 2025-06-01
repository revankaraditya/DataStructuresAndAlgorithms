import java.util.Arrays;

public class Main
{
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = BinarySearch.searchNormal(array,10);
        System.out.println("Element at index: " + result);
        result = BinarySearch.searchRecursive(array,8);
        System.out.println("Element at index: " + result);

        int[] test = {9,8,7,6,5,4,3,2,1};
        SortingAlgo.bubbleSort(test);
        System.out.println(Arrays.toString(test));

        int[] test1 = {9,8,7,6,5,4,3,2,1};
        SortingAlgo.selectionSort(test1);
        System.out.println(Arrays.toString(test1));

        int[] test2 = {9,8,7,6,5,4,3,2,1};
        SortingAlgo.insertionSort(test2);
        System.out.println(Arrays.toString(test2));

        int[] test3 = {9,8,7,6,5,4,3,2,1};
        SortingAlgo.mergeSort(test3);
        System.out.println(Arrays.toString(test3));
    }
}
