import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        LinkedList list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        list.removeLast();
        System.out.println(list.contains(10));
        System.out.println(list);
        System.out.println(list.size());
        var array = list.toArray();
        System.out.println(Arrays.toString(array));
         */
        MyLinkedList myList = new MyLinkedList();
        //myList.removeFirst();
        myList.addFirst(10);
        myList.removeLast();
        //myList.print();
        myList.addFirst(20);
        myList.addFirst(30);
        myList.addLast(40);
        myList.addLast(100);
        myList.addFirst(5);
        System.out.println(myList);
        myList.removeFirst();
        System.out.println(myList);
        myList.removeLast();
        System.out.println(myList);
        System.out.println(myList.contains(40));
        System.out.println(myList.indexOf(40));
        System.out.println(myList.size());
        System.out.println(Arrays.toString(myList.toArray()));
        myList.reverse();
        System.out.println(myList);
        System.out.println(myList.getKthFromTheEnd(3));
        myList.addLast(50);
        myList.addLast(60);
        myList.addLast(70);
        myList.addLast(80);
        myList.addLast(90);
        //myList.addLast(100);
        System.out.println(myList);
        myList.printMiddle();
        System.out.println(myList);
        myList.createLoop(4);
        System.out.println(myList);
        System.out.println(myList.hasLoop());
    }
}