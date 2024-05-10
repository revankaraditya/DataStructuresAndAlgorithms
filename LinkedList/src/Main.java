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
        myList.print();
        myList.removeFirst();
        myList.print();
        myList.removeLast();
        myList.print();
        System.out.println(myList.contains(40));
        System.out.println(myList.indexOf(40));
    }
}