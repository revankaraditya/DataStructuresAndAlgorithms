public class Main {
    public static void main(String[] args) {
        var algo = new Algorithms();
        int[] input = {9,5,31,3,6,7,33,5,66};
        var index1 = algo.linearSearch(input,3);
        System.out.println(index1);


        int[] input2 = {1,2,3,4,5,6,7,8};   //Sorted input for binary search
        var index2 = algo.binarySearchRecursive(input2,1);
        System.out.println(index2);
        var index3 = algo.binarySearchIterative(input2,1);
        System.out.println(index3);

        var index4 = algo.ternarySearch(input2,4);
        System.out.println(index4);

        var index5 = algo.jumpSearch(input2,4);
        System.out.println(index5);

        var index6 = algo.exponentialSearch(input2,8);
        System.out.println(index6);
    }
}