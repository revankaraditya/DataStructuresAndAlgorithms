public class Main {
    public static void main(String[] args) {
        System.out.println(StringUtils.countVowels("Aditya"));
        System.out.println(StringUtils.reverse("abb"));
        System.out.println(StringUtils.reverseWords("aditya revankar"));
        var result = StringUtils.checkRotation("ABCD","ADBC");
        System.out.println(result);
        System.out.println(StringUtils.removeDuplicates("aditya Revankar"));
        System.out.println(StringUtils.mostRepeatedCharacter("aditya revankar"));
        System.out.println(StringUtils.sentenceCapitalization("   aditya    revankar  "));
        System.out.println(StringUtils.checkAnagrams("ABCD","CABD"));
        System.out.println(StringUtils.checkAnagrams2("ABCD","CABB"));
        System.out.println(StringUtils.isPalindrome("nayan"));
    }
}