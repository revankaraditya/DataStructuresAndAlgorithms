public class MyLinkedList {
    private Node first=null;
    private Node last=null;

    public void addFirst(int value){
        if(first==null){
            first = new Node(value,null);
            last=first;
        }
        else {
            Node node = new Node(value, first);
            first = node;
        }
    }
    public void addLast(int value){
        Node node = new Node(value,null);
        updateLastNode();
        last.setNext(node);
        last=node;
    }

    public void deleteFirst(){
        Node node = first;
        if(node==null){
            System.out.println("No items in the list to delete");
        }
        else{
            first = node.getNext();
        }
    }

    public void deleteLast(){
        if(first!=null) {
            last = first;
            while (true) {
                try {
                    if (last.getNext().getNext() == null)
                        break;
                    last = last.getNext();
                }catch(NullPointerException e){
                    first=null;
                    break;
                }
            }
            last.setNext(null);
        }
        else{
            System.out.println("No items in the list to delete");
        }
    }

    private void updateLastNode() {
        last = first;
        while(true){
            if(last.getNext()==null)
                break;
            last = last.getNext();
        }
    }

    public boolean contains(int item){
        if(first==null){
            System.out.println("No items in the list to search");
        }
        else {
            Node node = first;
            while (true) {
                if(node.getValue()==item)
                    return true;
                node = node.getNext();
                if (node == null)
                    break;
            }
        }
        return false;
    }

    public int indexOf(int item){
        int index=0;
        int flag=0;
        if(first==null){
            System.out.println("No items in the list to find index");
        }
        else {
            Node node = first;
            while (true) {
                if(node.getValue()==item) {
                    flag = 1;
                    break;
                }
                node = node.getNext();
                if (node == null)
                    break;
                index++;
            }
        }
        if(flag==1)
            return index;
        else
            return -1;
    }

    public void print(){
        if(first==null){
            System.out.println("No items in the list to print");
        }
        else {
            Node node = first;
            while (true) {
                System.out.print(node.getValue());
                node = node.getNext();
                if (node == null)
                    break;
                System.out.print(">");
            }
            System.out.println();
        }
    }
}
