import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        int[] arr = new int[10];
        System.out.println(arr);    //Displays array location
        System.out.println(Arrays.toString(arr));   //Display array in the form of list
        arr[0]=10;
        arr[1]=20;
        System.out.println(Arrays.toString(arr));

        int[] arr1 = {1,2,3,4,5};
        System.out.println(arr1.length);

        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        //list.indexOf(20);
        Object[] arrayNew = list.toArray();
//        System.out.println(Arrays.toString(arrayNew));
//        System.out.println(arrayNew);
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of array: ");
        int len = sc.nextInt();
        Array myArray = new Array(len);
        int choice;
        while(true){
            System.out.println("1.InsertEnd\n" +
                    "2.InsertAt\n" +
                    "3.RemoveAt\n" +
                    "4.Print\n" +
                    "5.Max\n" +
                    "6.IndexOf\n" +
                    "7.Intersect\n" +
                    "8.Reverse\n");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print(">(item) ");
                    myArray.insert(sc.nextInt());
                    break;
                case 2:
                    System.out.print(">(item,index) ");
                    myArray.insertAt(sc.nextInt(),sc.nextInt());
                    break;
                case 3:
                    System.out.print(">(index) ");
                    myArray.removeAt(sc.nextInt());
                    break;
                case 4:
                    myArray.print();
                    break;
                case 5:
                    System.out.println("Max: " + myArray.max());
                    break;
                case 6:
                    System.out.print(">(item) ");
                    System.out.println(myArray.indexOf(sc.nextInt()));
                    break;
                case 7:
                    System.out.print(">(len) ");
                    int l = sc.nextInt();
                    int[] a = new int[l];
                    System.out.print(">(items) ");
                    for(int i=0;i<len;i++){
                        a[i] = sc.nextInt();
                    }
                    System.out.println(Arrays.toString(myArray.intersect(a)));
                    break;
                case 8:
                    System.out.println(">Reversed Array: " + Arrays.toString(myArray.reverse()));
                    break;
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
}