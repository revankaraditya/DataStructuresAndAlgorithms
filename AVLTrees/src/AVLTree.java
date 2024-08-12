public class AVLTree {
    private class AVLNode{
        private int value;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int height;
        public AVLNode(int value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "Node : " + value;
        }
    }

    private AVLNode root;
    public void insert(int value){
        root = insert(root,value);
    }
    private AVLNode insert(AVLNode root,int value){
        if(root==null)
            return new AVLNode(value);
        if(value<root.value)
            root.leftChild = insert(root.leftChild,value);
        else
            root.rightChild = insert(root.rightChild,value);

        //root.height = updateHeight(root);
        root.height = setHeight(root);

        //balance Factor
//        int balanceFactor = (root.leftChild==null? -1 : root.leftChild.height) -
//                            (root.rightChild==null? -1 : root.rightChild.height);
//        if(balanceFactor<-1)
//            System.out.println(root + " Right heavy");
//        else if(balanceFactor>1)
//            System.out.println(root + " Left Heavy");

        root = balance(root);

        return root;
    }

    private AVLNode balance(AVLNode root){
        if(isRightHeavy(root)) {
            if(balanceFactor(root.rightChild)>0)
                root.rightChild=rightRotate(root.rightChild);
            return leftRotate(root);
        }
        else if(isLeftHeavy(root)){
            if(balanceFactor(root.leftChild)<0)
                root.leftChild=leftRotate(root.leftChild);
            return rightRotate(root);
        }
        return root;
    }

//    private int updateHeight(AVLNode root){
//        if(root==null)
//            return -1;      //Height of an empty tree is -1
//        if(root.rightChild==null && root.leftChild==null){
//            return 0;
//        }
//        return Math.max(updateHeight(root.leftChild), updateHeight(root.rightChild)) + 1;
//    }

    private AVLNode leftRotate(AVLNode root){
        var newRoot = root.rightChild;
        root.rightChild=newRoot.leftChild;
        newRoot.leftChild = root;
        root.height= setHeight(root);
        newRoot.height=setHeight(newRoot);
        return newRoot;
    }
    private AVLNode rightRotate(AVLNode root){
        var newRoot = root.leftChild;
        root.leftChild=newRoot.rightChild;
        newRoot.rightChild = root;
        root.height= setHeight(root);
        newRoot.height=setHeight(newRoot);
        return newRoot;
    }

    private int setHeight(AVLNode root) {
        return Math.max(height(root.leftChild),
                height(root.rightChild)) + 1;
    }

    private int height(AVLNode root){
        return (root==null)?-1:root.height;
    }
    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1 ;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1 ;
    }
    private int balanceFactor(AVLNode node){
        return node==null? 0 : height(node.leftChild) - height(node.rightChild);
    }
}
