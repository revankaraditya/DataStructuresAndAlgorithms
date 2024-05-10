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
}
