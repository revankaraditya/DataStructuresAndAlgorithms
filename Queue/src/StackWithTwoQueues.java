import java.util.ArrayDeque;
import java.util.Queue;

public class StackWithTwoQueues {
    private Queue<Integer> queue1 = new ArrayDeque<>();
    private Queue<Integer> queue2 = new ArrayDeque<>();

    public void push(int item){
        queue2.add(item);
    }
    private int pop(){
        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }
    }
}
