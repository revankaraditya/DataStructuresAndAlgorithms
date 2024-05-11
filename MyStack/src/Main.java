public class Main {
    public static void main(String[] args) {
        StringReverser reverser = new StringReverser();
        var result = reverser.reverser("Hello");
        System.out.println(result);

        Expression exp = new Expression();
        System.out.println(exp.isBalanced("(([a+b]))"));

        var stack = new MyStack(3);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.print();
        stack.pop();
        stack.print();
        stack.pop();
        stack.print();
        stack.push(30);
        stack.print();
        System.out.println(stack.peek());
    }
}