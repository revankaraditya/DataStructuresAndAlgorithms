import java.util.Stack;

public class PDASimulator {
    private static final char EPSILON = 'ε';
    private Stack<Character> stack;

    public PDASimulator() {
        stack = new Stack<>();
        stack.push('$'); // Initial stack symbol
    }

    public boolean isAccepted(String input) {
        int currentIndex = 0;
        int inputLength = input.length();

        while (currentIndex < inputLength) {
            char currentSymbol = input.charAt(currentIndex);

            if (currentSymbol == EPSILON) {
                currentIndex++;
                continue;
            }

            char topOfStack = stack.peek();
            if (topOfStack == currentSymbol) {
                stack.pop();
                currentIndex++;
            } else if (topOfStack == EPSILON) {
                stack.pop();
            } else {
                stack.push(currentSymbol);
                currentIndex++;
            }
        }

        // Check if the remaining input is a palindrome
        StringBuilder remainingInput = new StringBuilder();
        while (!stack.isEmpty() && stack.peek() != '$') {
            remainingInput.insert(0, stack.pop());
        }

        String reversedInput = new StringBuilder(input).reverse().toString();
        return remainingInput.toString().equals(reversedInput) && inputLength % 2 == 0 && remainingInput.length() % 2 == 0;
    }

    public static void main(String[] args) {
        PDASimulator pda = new PDASimulator();
        String[] testStrings = {"abba", "aaabbaaa", "aba", "abbba", "baaab"};

        for (String testString : testStrings) {
            boolean accepted = pda.isAccepted(testString);
            System.out.println(testString + " is " + (!accepted ? "accepted" : "rejected") + " by the PDA.");
        }
    }
}
