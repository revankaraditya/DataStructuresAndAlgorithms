import java.util.ArrayDeque;
import java.util.PriorityQueue;
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

        System.out.println("\n\nTwo Stack Queue");
        var tsq = new TwoStackQueue();
        tsq.enqueue(10);
        tsq.enqueue(20);
        tsq.enqueue(30);
        tsq.enqueue(40);
        tsq.enqueue(50);
        tsq.enqueue(60);
        System.out.println(tsq);
        tsq.dequeue();
        System.out.println(tsq);

        System.out.println("\n\npriority queue");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(6);
        pq.add(4);
        pq.add(3);
        System.out.println(pq);
        while(!pq.isEmpty())
            System.out.println(pq.remove());

        System.out.println("\n\nCustom priority queue");
        MyPriorityQueue cpq = new MyPriorityQueue(5);
        cpq.add(40);
        cpq.add(50);
        cpq.add(10);
        cpq.add(20);
        cpq.add(30);
        System.out.println(cpq);
        cpq.remove();
        System.out.println(cpq);
        cpq.remove();
        System.out.println(cpq);

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