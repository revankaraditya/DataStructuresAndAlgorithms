import java.util.Stack;

public class Temp {
    private static int count = 3;
    private static int c = 5;

    public void print() {
        if (count-- > 0) {
            print();
            System.out.println(count);
        }
    }
    public int factorial(int n){
        if(n==0 || n==1)
            return 1;
        return n*factorial(n-1);
    }
    public void print5times(){
        if(c-- > 0){
            print5times();
            System.out.println("Aditya");
        }
    }

    public void printAcs(int i, int number){
        if(i>number)
            return;
        System.out.println(i);
        printAcs(++i,number);
    }

    public void printDec(int num){
        if(num>=0){
            System.out.println(num);
            printDec(--num);
        }
    }
    public boolean isPalindrome(String name){
        int len = name.length();
        for(int i=0,j=len-1;i<=j;i++,j--){
            if(name.charAt(i)!=name.charAt(j))
                return false;
        }
        return true;
    }

    public int fibonacci(int n){
        if(n<2)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public void printFibonacci(int n,int i){
        if(i==n+1)
            return;
        System.out.println(fibonacci(i));
        printFibonacci(n,i+1);
    }
}
