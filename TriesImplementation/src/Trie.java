import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Trie {
    private class Node{
        public static int ALPHABET_SIZE = 26;
        private char value;
        private HashMap<Character,Node> children = new HashMap<>();
        private boolean isEndOfWord;
        public Node(char value){
            this.value=value;
        }
        public boolean hasChild(char ch){
            return children.containsKey(ch);
        }
        public void addChild(char ch){
            children.put(ch,new Node(ch));
        }
        public Node getChild(char ch){
            return children.get(ch);
        }
        public Node[] getChildren(){
            return children.values().toArray(new Node[0]);
        }
        public boolean hasChildren(){
            return !children.isEmpty();
        }
        public void removeChild(char ch){
            children.remove(ch);
        }
        @Override
        public String toString(){
            return "Node: " + value;
        }
    }
    private Node root = new Node(' ');

    public void insert(String word){
        var current = root;
        for(char ch:word.toCharArray()){
            if(!current.hasChild(ch)){
                current.addChild(ch);
            }
            current = current.getChild(ch);
        }
        current.isEndOfWord=true;
    }
    public boolean contains(String word){
        if(word == null || word.isEmpty())
            throw new IllegalStateException("Invalid word to search");
        var current = root;
        for(char ch:word.toCharArray()){
            if(!current.hasChild(ch))
                return false;
            current=current.getChild(ch);
        }
        return current.isEndOfWord;
    }
    public void preOrderTraversal(){
        preOrderTraversal(root);
    }
    private void preOrderTraversal(Node root){
        System.out.println(root.value);
        for(Node child: root.getChildren()){
            preOrderTraversal(child);
        }
    }
    public void postOrderTraversal(){
        postOrderTraversal(root);
    }
    private void postOrderTraversal(Node root){
        for(Node child: root.getChildren()){
            postOrderTraversal(child);
        }
        System.out.println(root.value);
    }

    public void remove(String word){
        if(word==null)
            return;
        remove(root,word,0);
    }
    private void remove(Node root,String word,int index){
        if(index==word.length()) {
            root.isEndOfWord=false;
            return;
        }
        var ch = word.charAt(index);
        var child = root.getChild(ch);
        if(child==null)
            return;
        remove(child,word,index+1);

        if(!child.hasChildren() && !child.isEndOfWord){
            root.removeChild(ch);
        }
    }
    public List<String> findWords(String prefix){
        var lastnode = findLastNodeOf(prefix);
        List<String> words = new ArrayList<>();
        findWords(lastnode,prefix,words);
        return words;
    }
    public Node findLastNodeOf(String prefix){
        if(prefix==null)
            return null;
        var current = root;
        for(char ch:prefix.toCharArray()){
            var child  = current.getChild(ch);
            if(child==null)
                return null;
            current=child;
        }
        return current;
    }
    private void findWords(Node root,String prefix,List<String> words){
        if(root==null)
            return;
        if(root.isEndOfWord)
            words.add(prefix);
        for(var child:root.getChildren())
            findWords(child,prefix+child.value,words);
    }
}
