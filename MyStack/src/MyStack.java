import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyStack {
    private int capacity;
    private int top=-1;
    private int[] stack;
    public MyStack(int capacity) {
        this.capacity = capacity;
        stack = new int[capacity];
    }
    public void push(int item){
        if(isFull())
            throw new IllegalArgumentException("Stack is Full");
        stack[++top] = item;
    }
    public int pop(){
        if(isEmpty())
            throw new NoSuchElementException("Stack is Empty");
        return stack[top--];
    }
    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException("Stack is Empty");
        return stack[top];
    }

    private boolean isEmpty() {
        return top==-1;
    }

    private boolean isFull() {
        return top==capacity-1;
    }
    public void print(){
        if(isEmpty())
            throw new NoSuchElementException("Stack is Empty");
        for(int i=0;i<=top;i++)
            System.out.print(stack[i] + "<");
        System.out.println();
    }
}
