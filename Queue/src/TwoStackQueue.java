import java.util.Objects;
import java.util.Stack;

public class TwoStackQueue {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(int item){
        stack1.push(item);
    }
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue is empty");
        moveStack1ToStack2();
        return stack2.pop();
        /* Higher Time Complexity
        Stack<Integer> temp = new Stack<>();
        while(!items.isEmpty()){
            temp.push(items.pop());
        }
        var ele = temp.pop();
        while(!temp.isEmpty()){
            items.push(temp.pop());
        }
        return ele;
         */
    }
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException("Queue is empty");
        moveStack1ToStack2();
        return stack2.peek();
    }

    private void moveStack1ToStack2() {
        if (stack2.isEmpty())
            while (!stack1.isEmpty())
                stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString(){
        Stack<Integer> s1= (Stack<Integer>) stack1.clone();
        Stack<Integer> s2= (Stack<Integer>) stack2.clone();
        StringBuilder s = new StringBuilder();
        while(!s2.isEmpty())
            s.append(s2.pop()).append("<-");
        while(!s1.isEmpty())
            s2.push(s1.pop());
        while(!s2.isEmpty())
            s.append(s2.pop()).append("<-");
        return s.toString();
    }
}

