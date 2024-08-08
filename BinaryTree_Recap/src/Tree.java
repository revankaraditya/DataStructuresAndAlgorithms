public class Tree {
    private class Node {
        private final int value;
        private Node leftNode;
        private Node rightNode;

        Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node: " + value;
        }
    }

    private Node root = null;

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        var current = root;
        var newNode = new Node(value);
        //Find a parent for the node
        while (true) {
            if (value == current.value) {
                throw new IllegalStateException("Value Already Exists");
            } else if (value < current.value) {
                if (current.leftNode == null) {
                    current.leftNode = newNode;
                    return;
                }
                current = current.leftNode;
            } else if (value > current.value) {
                if (current.rightNode == null) {
                    current.rightNode = newNode;
                    return;
                }
                current = root.rightNode;
            }
        }
    }
    public boolean find(int value){
        var current = root;
        if(current==null){
            throw new IllegalStateException("Tree is Empty");
        }
        while(current!=null){
            if(value>current.value)
                current=current.rightNode;
            else if(value<current.value)
                current=current.leftNode;
            else
                return true;
        }
        return false;
    }

    private void preOrder(Node current){
        //root,left,right
        if(current==null)
            return;
        System.out.print(current.value + ">");
        preOrder(current.leftNode);
        preOrder(current.rightNode);

//        System.out.print(current.value + ">");
//        if(current.leftNode!=null)
//            preOrder(current.leftNode);
//        if(current.rightNode!=null)
//            preOrder(current.rightNode);
    }
    public void preOrder(){
        preOrder(root);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node root){
        //left,root,right
        if(root==null)
            return;
        inOrder(root.leftNode);
        System.out.print(root.value + ">");
        inOrder(root.rightNode);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node root){
        //left,right,root
        if(root==null)
            return;
        postOrder(root.leftNode);
        postOrder(root.rightNode);
        System.out.print(root.value + ">");
    }
    public int getHeight(){
        return getHeight(root);
    }
    private int getHeight(Node node){
        if(node==null)
            return -1;
        if(node.leftNode==null && root.rightNode==null)
            return 0;
        return 1 + Math.max(getHeight(node.leftNode),getHeight(node.rightNode));
    }
    public int minValue(){
        return minValue(root);
    }
    private int minValue(Node node){    // For Binary Tree
//        if(node==null)
//            throw new IllegalStateException("Tree Empty");
        if(node.leftNode==null && node.rightNode==null)
            return node.value;
        return Math.min(node.value,Math.min(minValue(node.leftNode),minValue(node.rightNode)));
    }
    public int minBst(){    //For bst
        if(root==null)
            throw new IllegalStateException("Tree Empty");
        var current  = root;
        var last=current;
        while(current!=null){
            last=current;
            current=current.leftNode;
        }
        return last.value;
    }
    public int maxBst(){    //For bst
        if(root==null)
            throw new IllegalStateException("Tree Empty");
        var current  = root;
        var last=current;
        while(current!=null){
            last=current;
            current=current.rightNode;
        }
        return last.value;
    }

    public boolean equalsBST(Tree tree){
        var p1 = root;
        var p2 = tree.root;
        return equalsBST(p1,p2);
    }
    private boolean equalsBST(Node n1,Node n2){
        if(n1.value!= n2.value)
            return false;
        if(n1.leftNode==null && n2.leftNode==null)
            return true;
        if(n1.rightNode==null && n2.rightNode==null)
            return true;
        equalsBST(n1.leftNode,n2.leftNode);
        equalsBST(n1.rightNode,n2.rightNode);
        return true;
    }
}
