import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.nextLine().toCharArray();
        var result = new StringBuilder();
        int len=0;
        for(int i=0;i<input.length;i++){
            if(input[i]!=' ') {
                result.append(input[i]);
                len++;
            }
        }
        System.out.println(result);
    }
}