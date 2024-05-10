import java.util.NoSuchElementException;

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
    }

    public void addLast(int item){
        var node = new Node(item);
        if(isEmpty())
            first=last=node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first==last){
            first=last=null;
            return;
        }
        var second = first.next;
        first.next=null;
        first=second;
    }

    public void removeLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(first==last){
            first=last=null;
            return;
        }
        var previous = getPrevious(last);
        last=previous;
        last.next=null;
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

    public void print(){
        if(isEmpty())
            throw new NoSuchElementException();
        else {
            var current = first;
            while (current != null) {
                System.out.print(current.value + "->");
                if(current.next==null)
                    break;
                current = current.next;
            }
        }
        System.out.println();
    }
}
