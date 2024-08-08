public class Main {
    public static void main(String[] args) {
        Tree bst = new Tree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(6);
        bst.insert(1);
        bst.insert(8);
        bst.insert(12);
        bst.insert(18);
        bst.insert(19);
        System.out.println(bst.find(10));
        System.out.println(factorial(5));
    }
    public static int factorial(int item){
        if(item==0)
            return 1;
        return item*factorial(--item);
    }
}