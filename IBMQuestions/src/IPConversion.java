import java.util.Arrays;

public class IPConversion {
    public static String toIPv6(String IPv4){
        String[] ip = IPv4.strip().split("\\.");
        if(ip.length != 4) {
            return "Invalid Input";
        }
        if(ip[0].equals("127"))
            return "::1";
        System.out.println();
        return "::FFFF:" +
                (Integer.toHexString(Integer.parseInt(ip[0])) +
                Integer.toHexString(Integer.parseInt(ip[1])) +
                ":" +
                Integer.toHexString(Integer.parseInt(ip[2])) +
                Integer.toHexString(Integer.parseInt(ip[3]))).toUpperCase();
    }
    public static String toHexadecimal(int number){
        var hexadecimal  = new StringBuilder();
        while(true){
            var remainder = number % 16;
            if(remainder==10)
                hexadecimal.append("A");
            else if(remainder==11)
                hexadecimal.append("B");
            else if(remainder==12)
                hexadecimal.append("C");
            else if(remainder==13)
                hexadecimal.append("D");
            else if(remainder==14)
                hexadecimal.append("E");
            else if(remainder==15)
                hexadecimal.append("F");
            else
                hexadecimal.append(remainder);
            if(remainder==number)
                break;
            number = number / 16;
        }
        if(hexadecimal.length()==1)
            hexadecimal.append("0");
        return hexadecimal.reverse().toString();
    }
}
