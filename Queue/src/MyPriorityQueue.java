import java.util.Arrays;

public class MyPriorityQueue {
    private int[] items;
    private int capacity;
    private int count;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
    }
    public void add(int item){
        if(isFull())
            throw new IllegalStateException("Queue full");
        int i = shiftItemsToInsert(item);
        items[i]=item;
        count++;
    }

    public int shiftItemsToInsert(int item){
        int i;
        for(i=count-1;i>=0;i--){
            if(item < items[i]){
                items[i+1] = items[i];
            }
            else
                break;
        }
        return i+1;
    }

    private boolean isFull() {
        return count == items.length;
    }

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException("Queue Empty");
        int item = items[0];
        for(int i=0;i<count-1;i++){
            items[i] = items[i+1];
        }
        items[--count] = 0;
        return item;
    }

    private boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
