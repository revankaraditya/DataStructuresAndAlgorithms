import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue);
//        var front = queue.remove();
//        System.out.println(front);
//        System.out.println(queue);
        reverse(queue);
        System.out.println(queue);

        System.out.println("************************************************");
        ArrayQueue myqueue = new ArrayQueue(4);
        //myqueue.print();      //Empty
        myqueue.enqueue(10);
        myqueue.enqueue(20);
        myqueue.enqueue(30);
        myqueue.enqueue(40);
        System.out.println(myqueue);
        //myqueue.enqueue(50);  //Full
        myqueue.dequeue();
        System.out.println(myqueue);
        myqueue.dequeue();
        System.out.println(myqueue);
        myqueue.dequeue();
        System.out.println(myqueue);
        myqueue.dequeue();
        System.out.println(myqueue);
        myqueue.enqueue(10);
        System.out.println(myqueue);
        myqueue.dequeue();
        System.out.println(myqueue);
    }
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.push(queue.remove());
        }
        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }
    }
}