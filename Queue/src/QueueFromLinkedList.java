public class QueueFromLinkedList {
    private class Node{
        private int value;
        private Node next;

        private Node(int value) {
            this.value = value;
        }
    }
    private Node head;
    private Node tail;
    private int count;
    private int capacity;
    public QueueFromLinkedList(int capacity){
        this.capacity=capacity;
    }

    //AddLast
    public void enqueue(int item){
        if(isFull())
            throw new IllegalStateException("Queue full");
        var node = new Node(item);
        if(isEmpty()){
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
        count++;
    }

    private boolean isFull() {
        return count == capacity;
    }

    //removeFirst
    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException("Queue empty");
        int value;
        if(head==tail){
            value = head.value;
            head=tail=null;
        }
        else {
            value = head.value;
            var second = head.next;
            head.next = null;
            head=second;
        }
        count--;
        return value;
    }
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException("Queue empty");
        return head.value;
    }

    private boolean isEmpty() {
        return head==null;
    }

    public int size(){
        return count;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        var node = head;
        while(node!=null){
            result.append(node.value).append('-');
            node=node.next;
        }
        return result.toString();
    }


}
