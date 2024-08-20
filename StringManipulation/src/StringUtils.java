import java.util.*;

public class StringUtils {
    public static int countVowels(String input){
        if(input==null)
            return 0;
        var count = 0;

        //Using String
        String vowels = "aeiou";
        //instead of using a string we can use SET
        //because sets are ideal for looking up values
        //for large string use set
        for(char c:input.toLowerCase().toCharArray())
            if(vowels.indexOf(c)!=-1) // Another way :> vowels.contains(Character.toString(c))
                count++;

        //Using set, suitable for larger string matching
        int count1=0;
        var vowelsSet = new HashSet<String>();
        vowelsSet.add("a");
        vowelsSet.add("e");
        vowelsSet.add("i");
        vowelsSet.add("o");
        vowelsSet.add("u");
        for(char c:input.toLowerCase().toCharArray())
            if(vowelsSet.contains(Character.toString(c)))
                count1++;

        //return count;   //For String implementation
        return count1;

//Poor Way of writing code
//        var count=0;
//        for(char c: input.toLowerCase().toCharArray()){
//            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
//                count++;
//        }
//        return count;
    }

    public static String reverse(String input){
        if(input==null)
            return "";

        //Using character array
        char[] charArray = input.toCharArray();
        for(int i=0;i<charArray.length/2;i++){
            var temp = charArray[i];
            charArray[i] = charArray[charArray.length-i-1];
            charArray[charArray.length-i-1] = temp;
        }
        //return String.valueOf(charArray);

        //Using stack (Uses more space)
        char[] charArray2 = input.toCharArray();
        var stack = new Stack<Character>();
        for(char c: charArray2)
            stack.push(c);
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
            result.append(stack.pop());
        //return result.toString();

        //Using separate String
        StringBuilder reversed = new StringBuilder();
        for(var i=input.length()-1;i>=0;i--)    //O(n)
            reversed.append(input.charAt(i));   //O(1)
        return reversed.toString();

    }

    public static String reverseWords(String sentence){
        if(sentence==null)
            return "";
        //The trim method is used to trim the leading and trailing whitespaces
        //The split method in string is used to split a expression on a particular char
        String[] words = sentence.trim().split(" ");
        //Collections class has a inbuilt method to sort the items
        //That is an object of collection has to be passed as an argument
        Collections.reverse(Arrays.asList(words));
        //Then we use the join method of string class to create the string from array
        return String.join(" ",words);

// Another Implementation
//        String[] words = sentence.trim().split(" ");
//        StringBuilder reversed = new StringBuilder();
//        for(var i = words.length-1;i>=0;i--)
//            reversed.append(words[i] + " ");
//        return reversed.toString().trim();
    }

    public static boolean checkRotation(String str1, String str2){
        /*
         ABCD -> DABC 1
                 CDAB 2
                 BCDA 3
                 ABCD 4
        > Input and the output have same length
        > They have same order of characters

        Join the input twice: CD'AB,CD'AB

        If the strings are large then it is not feasible by space to join and check
        So here we use For loop to check rotations
         */

        /* Method 1
        if(str1==null||str2==null)
            return false;
        return (str1.length()==str2.length() && (str2+str2).contains(str1));
         */

        /*
        Method 2: Using two pointers
        Consider pointer j for str1 and i for str2

        If j successfully iterates and reaches end then the string is valid
        If j is at the start position and i has finished a loop then the string is invalid
         */
        if(str1==null || str2==null || (str1.length()!=str2.length()))
            return false;
        int j=0,i=0;
        while(j<str1.length()){
            if(str1.charAt(j) == str2.charAt(i))  //if the char at ith and jth position match the increment j
                j++;
            else    //if characters does not match then reset j
                j=0;
            if(i==str2.length()-1 && j==0)
                return false;
            i = ++i%str2.length();  //increment i in circular fashion
        }
        return j == str1.length();  //if j equals the length of the string then the strings are valid
    }

    public static String removeDuplicates(String str){
        if(str==null)
            return "";
        HashSet<Character> set = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for(char c:str.toCharArray()) {
            if(!set.contains(c)) {
                set.add(c);
                result.append(c);
            }
        }
        return result.toString();
    }
    public static char mostRepeatedCharacter(String str){
        /*
        What if hashtable is not permitted?
        > Use integer array to store frequencies
         */
        if(str==null || str.isEmpty())
            throw new IllegalStateException();
        final int ASCII_SIZE=255;
        int[] frequencies = new int[ASCII_SIZE];
        //update frequencies
        for(char c: str.toCharArray()){
            frequencies[c] +=1;
        }
        //find max frequency
        var max=0;
        char maxChar=' ';
        for(int i=0;i<frequencies.length;i++){
            if(frequencies[i]>max){
                max=frequencies[i];
                maxChar=(char) i;
            }
        }
        return maxChar;

        /* Hashtable Implementation
        if(str==null)
            return 0;
        var frequencies = new HashMap<Character,Integer>();
        var maxValue = Integer.MIN_VALUE;
        var maxChar = ' ';
        for(char c: str.toCharArray()){
            if(!frequencies.containsKey(c))
                frequencies.put(c,1);
            else
                frequencies.replace(c,frequencies.get(c)+1);

            if(frequencies.get(c) > maxValue) {
                maxValue = frequencies.get(c);
                maxChar = c;
            }
        }
        return maxChar;
         */

    }
    public static String sentenceCapitalization(String str){
        if(str==null || str.trim().isEmpty())
            return "";
        String[] words = str.trim() //remove leading and trailing whitespaces
                            .replaceAll(" +"," ")   //replaceAll takes basic regular expression, used to remove extra whitespaces between
                            .split(" ");    //splits the string into array
        for(int i=0;i<words.length;i++){
            words[i]=words[i].substring(0,1).toUpperCase()          //Convert the first character to uppercase
                    +words[i].substring(1).toLowerCase();   //convert the other characters to lowercase
        }
        return  String.join(" ",words);     //joint the strings using spaces
    }
    public static boolean checkAnagrams(String str1,String str2){
        //Convert the strings to characters and sort them and check for equality

        //Case-sensitive implementation
        //This implementation is not feasible for large strings
        //Total : O(nlog(n))
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;
        //O(n)
        char[] s1 = str1.toCharArray();
        //O(nlog(n))
        Arrays.sort(s1);
        char[] s2 = str2.toCharArray();
        Arrays.sort(s2);
        return Arrays.equals(s1,s2);

        /* Veryy complex implementation-do not use
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;
        var map1 = new HashMap<Character,Integer>();
        var map2 = new HashMap<Character,Integer>();
        for(int i=0;i<str1.length();i++){
            if(!map1.containsKey(str1.charAt(i)))
                map1.put(str1.charAt(i),1);
            else
                map1.put(str1.charAt(i),map1.get(str1.charAt(i))+1);
            if(!map2.containsKey(str2.charAt(i)))
                map2.put(str2.charAt(i),1);
            else
                map2.put(str2.charAt(i),map2.get(str2.charAt(i))+1);
        }
        return map1.equals(map2);
         */
    }
    public static boolean checkAnagrams2(String str1,String str2){
        //O(n)
        //Efficient than the first method
        if(str1==null || str2==null || str1.length()!=str2.length())
            return false;
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        final int TOTAL_ALPHABETS=26;
        int[] frequencies = new int[TOTAL_ALPHABETS];
        /*
        Methodology: First we increment the frequencies of characters using one string
        and then we decrement the frequencies using the other string
         */
        for(char c:str1.toCharArray())
            frequencies[c-'a']++;       // c-'a' > index
        for(char c:str2.toCharArray()) {
            if (frequencies[c - 'a'] == 0)  //if a foreign alphabet is found then return false
                return false;
            frequencies[c - 'a']--; //else decrement count
        }
        return true;
    }

    public static boolean isPalindrome(String str){
        /*  Reverse and check for equality (For small strings)
        var input = new StringBuilder(str);
        input.reverse();
        return input.toString().equals(str);
         */

        if(str==null)
            return false;
        //Iterate only the half string
        for(var i=0;i<str.length()/2;i++)
            if(str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
        return true;

    }
}
