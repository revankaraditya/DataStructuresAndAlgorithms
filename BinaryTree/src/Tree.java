public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        Node(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node: " + value;
        }
    }
    private Node root = null;
    void insert(int value){
        if(root==null){
            root = new Node(value);
            return;
        }
        var current = root;
        Node newNode = new Node(value);
        while(true) {
            if (current.value == value) {
                throw new IllegalStateException(value + " Already exists");
            } else if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = newNode;
                    break;
                }
                current = current.leftChild;
            } else if (value > current.value) {
                if (current.rightChild == null) {
                    current.rightChild = newNode;
                    break;
                }
                current = current.rightChild;
            }
        }
    }
    boolean find(int value){
        var current = root;
        while(current!=null){
            if (value < current.value) {
                if(current.leftChild==null)
                    break;
                current=current.leftChild;
            } else if (value > current.value) {
                if(current.rightChild==null)
                    break;
                current=current.rightChild;
            }
            else //equals
                return true;
        }
        return false;
    }
}
