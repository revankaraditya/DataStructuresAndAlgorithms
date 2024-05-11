import java.util.Stack;

public class BalancedExpression {
    public boolean check(String input){
        Stack<Character> stack = new Stack<>();
        for(char ch : input.toCharArray()){
            if(isBracket(ch)){
                if(ch=='('||ch=='{'||ch=='[')
                    stack.push(ch);
                else{
                    if(stack.isEmpty())
                        return false;
                    if(checkBrackets(stack.peek(),ch))
                        stack.pop();
                    else
                        stack.push(ch);
                }
            }
        }
        if(stack.isEmpty())
            return true;
        return false;
    }

    private boolean isBracket(char ch) {
        return ch=='(' || ch==')' || ch=='{' || ch=='}' || ch =='[' || ch==']';
    }
    private boolean checkBrackets(char opening,char closing){
        if(opening=='(' && closing==')')
            return true;
        else if(opening=='{' && closing=='}')
            return true;
        else return opening == '[' && closing == ']';
    }
}
