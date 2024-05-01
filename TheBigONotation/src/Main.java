public class Main {
    public static void main(String[] args) {
        /*Notes
        1.
        We use big O to describe the performance on an algorithm

        2.
        Big O Helps us to understand whether the application is scalable or not

        3.
        Binary Search is an example for O(log(n))
        Exponential growth is opposite of logarithmic growth

         */
    }
    public void bigO_1(int[] numbers){
        //multiple items but our method takes constant time
        System.out.println(numbers[0]);
        System.out.println(numbers[0]);
    }

    public void bigO_n(int[] numbers){
        //O(n)
        for(int i:numbers){
            System.out.println(i);
        }
        for(int i:numbers){
            System.out.println(i);
        }
    }

    public void bigO_n2(int[][] numbers){
        //O(n^2)
        for(int[] i:numbers){
            for(int j:i)
                System.out.println(j);
        }
    }

}