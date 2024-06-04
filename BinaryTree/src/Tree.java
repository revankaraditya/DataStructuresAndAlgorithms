public class Tree {
    private class Node{
        private int value;
        private Node leftChild;
        private Node rightChild;
        private int count;
        Node(int value){
            this.value = value;
        }
    }
    private Node root = null;

    void insert(int value){
        if(root==null){
            root = new Node(value);
            root.leftChild=null;
            root.rightChild=null;
        }
        else{
            var current = root;
            Node node = new Node(value);
            while(true) {
                if(current.value==value){
                    current.count++;
                    break;
                }
                else if (value < current.value) {
                    if(current.leftChild==null) {
                        current.leftChild = node;
                        break;
                    }
                    current=current.leftChild;
                }
                else if(value > current.value) {
                    if(current.rightChild==null){
                        current.rightChild = node;
                        break;
                    }
                    current=current.rightChild;
                }
            }
        }
    }
    boolean find(int value){
        var current = root;
        if(root==null){
            throw new IllegalStateException("BST Empty");
        }
        while(true){
            if(current.value==value)
                return true;
            else if (value < current.value) {
                if(current.leftChild==null)
                    break;
                current=current.leftChild;
            } else if (value > current.value) {
                if(current.rightChild==null)
                    break;
                current=current.rightChild;
            }
        }
        return false;
    }
}
