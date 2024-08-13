public class HeapImplementation {
    private int[] items = new int[10];
    private int size;
    public void insert(int value){
        if(isFull())
            throw new IllegalStateException();
        items[size++] = value;
        bubbleUp();
    }
    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        var root = items[0];
        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        items[0] = items[--size];   //now my size points to the last element in the heap
        while(index <=size && !isValidParent(index)){
            swap(index,largerChildIndex(index));
            index = largerChildIndex(index); //now the index becomes the index of the larger child
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int largerChildIndex(int index){
        if(!hasLeftChild(index))
            return index;
        if(!hasRightChild(index))
            return leftChildIndex(index);
        return (leftChild(index)>rightChild(index))?leftChildIndex(index):rightChildIndex(index);
    }
    private boolean hasLeftChild(int index){
        return leftChildIndex(index) <= size;
    }
    private boolean hasRightChild(int index){
        return rightChildIndex(index) <= size;
    }

    private boolean isValidParent(int index) {
        if(!hasLeftChild(index))
            return true;
        var isValid = items[index] >= leftChild(index);
        if(hasRightChild(index))
            isValid &= items[index] >= rightChild(index);
        return isValid;
    }

    private int leftChildIndex(int index){
        return index*2 + 1;
    }
    private int leftChild(int index){
        return items[leftChildIndex(index)];
    }
    private int rightChildIndex(int index){
        return index*2 + 1;
    }
    private int rightChild(int index){
        return items[rightChildIndex(index)];
    }


    private boolean isFull() {
        return size == items.length;
    }

    private void bubbleUp() {
        var index = size-1;
        while(index > 0 && items[index]>items[getParentIndex(index)]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }
    private void swapInArray(int[] array, int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    @Override
    public String toString(){
        var output = new StringBuilder();
        for(int i=0;i<size;i++)
            output.append(items[i]).append(", ");
        return output.toString();
    }

}
