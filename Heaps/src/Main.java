import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        var heap = new HeapImplementation();
        heap.insert(15);
        heap.insert(10);
        heap.insert(3);
        heap.insert(8);
        heap.insert(12);
        heap.insert(9);
        heap.insert(4);
        heap.insert(1);
        heap.insert(24);
        System.out.println(heap);
        System.out.println(heap.remove());
        System.out.println(heap);

       int[] numbers = {100,200,300,400,500};
       MaxHeap.heapify(numbers);
       System.out.println(Arrays.toString(numbers));

       int[] n = {19,15,114,48,11,136};
       MaxHeap.kthLargest(n,4);

    }
}