import java.util.Stack;

import static java.lang.Integer.MAX_VALUE;

public class Converter {
    int[] toBinary(int num){
        var stack = new Stack<Integer>();
        int len=0;
        while(num!=0){
            int rem = num % 2;
            stack.add(rem);
            num = num/2;
        }
        int[] result = new int[stack.size()];
        for(int i=0;!stack.isEmpty();i++){
            result[i] = stack.pop();
        }
        return result;
    }
    int singleFlippedMin(int num){
        int[] binary = toBinary(num);
        int min=MAX_VALUE;
        for(int i=0;i<binary.length;i++){
            int[] temp = binary.clone();
            if(temp[i]==0)
                temp[i]=1;
            else
                temp[i]=0;
            int decimal = toDecimal(temp);
            min = Math.min(min, decimal);
        }
        return min!=MAX_VALUE?min:0;
    }

    private int toDecimal(int[] temp) {
        int sum=0;
        for(int i=temp.length-1,j=0;i>=0;i--,j++){
            sum = sum + (int) (temp[i] * Math.pow(2,j));
        }
        return sum;
    }
}
