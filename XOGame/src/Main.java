import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        char[][] matrix = {{'x','o','o'},
                          {'o','x','x'},
                          {'x','x','x'}};

        var x = "xxx";
        var o = "ooo";
        List<String> str = new ArrayList<>();
        //Add all row possibilities
        for(var row: matrix)
            str.add(new String(row));
        //Add all column possibilities
        for(int i=0;i<3;i++){
            String s = String.valueOf(matrix[0][i]) +
                    matrix[1][i] +
                    matrix[2][i];
            str.add(s);
        }
        //Diagonal
        char[] c = {matrix[0][0],matrix[1][1],matrix[2][2]};
        str.add(new String(new char[]{matrix[0][0],matrix[1][1],matrix[2][2]}));
        str.add(new String(new char[]{matrix[0][2],matrix[1][1],matrix[2][0]}));

        System.out.println(str);
        //Result
        if(str.contains(x))
            System.out.println("X");
        else if(str.contains(o))
            System.out.println("O");
        else
            System.out.println("Draw");

    }
}