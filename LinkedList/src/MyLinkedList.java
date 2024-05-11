import java.util.NoSuchElementException;
import java.util.Objects;

public class MyLinkedList {
    private class Node {
        private int value;
        private Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    private Node first=null;
    private Node last=null;
    private int size;

    private boolean isEmpty() {
        return first == null;
    }

    public void addFirst(int item){
        var node = new Node(item);
        if(isEmpty())
            first = last = new Node(item);
        else {
            node.next = first;
            first=node;
        }
        size++;
    }

    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty())
            first=last=node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first==last){
            first=last=null;
        }
        else {
            var second = first.next;
            first.next = null;
            first = second;
        }
        size--;
    }

    public void removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first==last){
            first=last=null;
        }
        else {
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
        size--;
    }

    private Node getPrevious(Node node) {
        var current = first;
        while(current !=null){
            if(current.next==node)
                return current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public int indexOf(int item){
        int index=0;
        var current = first;
        while (current!=null){
            if(current.value==item)
                return index;
            current=current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        if(isEmpty())
            throw new NoSuchElementException();
        else {
            var current = first;
            while (current != null) {
                s.append(current.value).append("->");
                if(current.next==null)
                    break;
                current = current.next;
            }
        }
        return s.toString();
    }

    public int size(){
        return size;
    }

    public int[] toArray(){
        int[] array = new int[size];
        var current = first;
        int i=0;
        while(current!=null){
            array[i++] = current.value;
            current=current.next;
        }
        return array;
    }

    public void reverse(){
        if(isEmpty())
            return;
        //previous|current|next
        var previous = first;
        var current = previous.next;
        while(current!=null){
            var next = current.next;
            current.next=previous;
            previous=current;
            current=next;
        }
        last=first;
        last.next=null;
        first=previous;

    }

    public int getKthFromTheEnd(int k){
        //30 20 40
        //p2 p1
        if(k<=0 || k>size)
            throw new IllegalArgumentException("Invalid K value");
        var p1=first;
        var p2=first;
        for(int i=0;i<k-1;i++)
            p1=p1.next;
        while(p1!=last){
            p1=p1.next;
            p2=p2.next;
        }
        return p2.value;
    }

    public void printMiddle() {
        //a b
        if(isEmpty())
            throw new IllegalStateException();
        var a=first;
        var b=first;
        while(b!=last && b.next!=last){
            a=a.next;
            b=b.next.next;
        }
        if(b==last)
            System.out.println(a.value);
        else
            System.out.println(a.value +":"+a.next.value);
        /* does not happen in one pass
        if(isEmpty())
            throw new NullPointerException("List empty");
        var a = first;
        var b = last;
        while(true){
            if(a==b) {
                System.out.println(a.value);
                break;
            }
            if(a.next==b){
                System.out.println(a.value + ":" + b.value);
                break;
            }
            a=a.next;
            b=getPrevious(b);
        }
         */
    }

    public void createLoop(int k){
        var a=first;
        for(int i=1;i<k;i++){
            a=a.next;
        }
        var jointPoint = a;
        while(a.next!=null)
            a=a.next;
        a.next=jointPoint;
    }

    public boolean hasLoop(){
        if(isEmpty())
            throw new IllegalStateException();
        var a=first;
        var b=first;
        while(a!=b){
            a=a.next;
            b=b.next.next;
            if(a==b)
                return true;
        }
        return false;
    }
}
