import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no: ");
        int n = sc.nextInt();
        String s = " ";
        for(int i = 1;i<=n;i++){
            for(int x=1;x<=(n-i);x++) System.out.print(s);
            for(int j=1;j<=i;j++)
                System.out.print(i + " ");
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int x=1;x<=(n-i);x++) System.out.print(s);
            for(int j=1;j<=i;j++)
                System.out.print(j + " ");
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int x=1;x<=(n-i);x++) System.out.print(s);
            for(int j=1;j<=i;j++)
                System.out.print("*" + " ");
            System.out.println();
        }
        for(int i = 1;i<=n;i++){
            for(int x=1;x<=(n-i);x++) System.out.print(s + " ");
            for(int j=1;j<=i;j++)
                System.out.print(j+" ");
            for(int j=i-1;j>=1;j--)
                System.out.print(j +" ");
            System.out.println();
        }
    }
}