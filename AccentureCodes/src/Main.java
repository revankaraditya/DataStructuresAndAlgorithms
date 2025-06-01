public class Main {
    public static void main(String[] args) {
        var res1 = firstCode(new int[]{2,3,4,5,7,8},2,3,2,6);
        System.out.println(res1);
        var res2 = secondCode(5);
        System.out.println(res2);
    }
    //Dividend,Divisor,Quotient,Remainder
    public static int firstCode(int[] dividend,int quotient,int divisor,int remainder,int size){
        var calcDividend = (divisor * quotient) + remainder;
        int flag=-1;
        for(int i=0;i<dividend.length;i++){
            if(calcDividend==dividend[i]){
                flag=i;
                break;
            }
        }
        return flag;
    }
    //Special Fibonacci Series
    public static int secondCode(int input){
        if(input<0)
            return -1;
        if(input==0||input==1)
            return 1;
        return (int)(Math.pow(secondCode(input-1),2) +
                     Math.pow(secondCode(input-2),2)) % 47;
    }
}