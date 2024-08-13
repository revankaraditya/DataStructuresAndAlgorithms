public class PriorityQueueWithHeap {
    private HeapImplementation heap = new HeapImplementation();
    public void enqueue(int item){
        heap.insert(item);
    }
    public int dequeue(){
        return heap.remove();
    }
    public boolean isEmpty(){
        return heap.isEmpty();
    }
}
