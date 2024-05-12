import java.util.Arrays;

public class ArrayQueue {
    private int front;
    private int rear;
    private int[] items;
    private int capacity;
    private int count;

    public ArrayQueue(int capacity) {
        this.capacity=capacity;
        items = new int[capacity];
    }

    public boolean isEmpty(){
        return count==0;
    }
    public boolean isFull(){
        return count == items.length;
    }

    public void enqueue(int item){
        if(isFull())
            throw new IllegalStateException("Queue Full");
        items[rear] = item;
        rear=(rear+1)%items.length;
        count++;
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue Empty");
        var item =  items[front];
        items[front] = 0;
        front=(front +1)%items.length;
        count--;
        return item;
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException("Queue Empty");
        return items[front];
    }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
//    public void print(){
//        if(isEmpty())
//            throw new IllegalStateException("Queue Empty");
//        for(int i=front;i<=rear;i++){
//            System.out.print(items[i] + " < ");
//        }
//        System.out.println();
//    }
}
