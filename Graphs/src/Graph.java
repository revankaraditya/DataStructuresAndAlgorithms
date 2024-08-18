import java.util.HashMap;

public class Graph {
    private class Node{
        String label;
        public Node(String label) {
            this.label = label;
        }
    }
    int[][] graph;
    HashMap<String,Node> nodes = new HashMap<>();
    public void addNode(String label){
        var node = new Node(label);
        nodes.putIfAbsent(label,node);
    }
}
