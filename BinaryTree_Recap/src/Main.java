public class Main {
    public static void main(String[] args) {
        var bst = new Tree();
        bst.insert(7);
        bst.insert(4);
        bst.insert(9);
        bst.insert(1);
        bst.insert(6);
        bst.insert(8);
        bst.insert(10);
        System.out.println(bst.find(10));
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        System.out.println(bst.getHeight());
        System.out.println(bst.minValue());
        System.out.println(bst.minBst());
        System.out.println(bst.maxBst());

        var bst1 = new Tree();
        bst1.insert(7);
        bst1.insert(4);
        bst1.insert(9);
        bst1.insert(1);
        bst1.insert(6);
        bst1.insert(8);
        bst1.insert(10);
        System.out.println(bst.equalsBST(bst1));
    }
}