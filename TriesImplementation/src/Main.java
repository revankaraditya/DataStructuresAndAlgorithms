public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("car");
        trie.insert("care");
        trie.insert("card");
        trie.insert("curd");
        System.out.println(trie.contains("car"));
        trie.preOrderTraversal();
        System.out.println();
        trie.postOrderTraversal();
        trie.remove("car");
        System.out.println(trie.contains("car"));
        var words = trie.findWords("c");
        System.out.println(words);
    }
}