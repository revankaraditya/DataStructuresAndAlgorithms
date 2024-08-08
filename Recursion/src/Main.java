public class Main {
    public static void main(String[] args) {
        var temp = new Temp();
        temp.print();
        var fact = temp.factorial(5);
        System.out.println(fact);

        temp.print5times();
        temp.printAcs(1,10);
        temp.printDec(12);

        System.out.println(temp.isPalindrome("naan"));

    }
}