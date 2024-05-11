import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        StringReverser reverser = new StringReverser();
        var result = reverser.reverser("Hello");
        System.out.println(result);

        BalancedExpression exp = new BalancedExpression();
        System.out.println(exp.check("(([a+b]))"));

    }
}