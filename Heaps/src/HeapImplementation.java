import java.util.Arrays;

public class HeapImplementation {
    private int[] heap;
    private int currentIndex = -1;
    private int size;
    public HeapImplementation(int size){
        this.size=size;
        this.heap = new int[size];
    }
    public void insert(int value){
        if(++currentIndex<size){
            heap[currentIndex] = value;
            bubbleUp(currentIndex);
        }
        else{
            System.out.println("Heap Capacity Full");
        }
    }
    public void remove(){
        if(heap[0]==0){
            System.out.println("Heap Empty");
            return;
        }
        heap[0] = heap[currentIndex];
        heap[currentIndex]=0;
        currentIndex--;

        bubbleDown(0);
    }
    private void bubbleDown(int rootIndex){
        int leftIndex = rootIndex*2 + 1;
        int rightIndex = rootIndex*2 + 1;

        int leftChild = heap[leftIndex];
        int rightChild = heap[rightIndex];
        int root = heap[rootIndex];

        if(root>Math.max(leftChild,rightChild))
            return;

        if(root<leftChild){
            swap(rootIndex,leftIndex);
            bubbleDown(leftIndex);
        }
        else if(root<rightChild){
            swap(rootIndex,rightIndex);
            bubbleDown(rightIndex);
        }
    }

    private void bubbleUp(int currentIndex) {
        if(currentIndex==0)
            return;
        int parentIndex = currentIndex==1 || currentIndex==2?0:(currentIndex-1)/2;
        if(heap[parentIndex] < heap[currentIndex]){
            swap(parentIndex,currentIndex);
            bubbleUp(parentIndex);
        }
    }
    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
    @Override
    public String toString(){
        var output = new StringBuilder();
        for(int i=0;i<=currentIndex;i++)
            output.append(heap[i]).append(", ");
        return output.toString();
    }

}
