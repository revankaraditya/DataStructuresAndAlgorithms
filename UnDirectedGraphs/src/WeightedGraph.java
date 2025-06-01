import java.util.*;

public class WeightedGraph {
    private class Node{
        private String label;
        private List<Edge> edges = new ArrayList<>();   //Can also be a map

        public Node(String label) {
            this.label = label;
        }
        public void addEdge(Node to,int weight){
            edges.add(new Edge(this,to,weight));
        }
        public List<Edge> getEdges(){
            return edges;
        }
        @Override
        public String toString(){
            return label;
        }
    }
    private class Edge{
        private Node from;
        private Node to;

        private int weight;

        public Edge(Node from, Node to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString(){
            return from + "->" + to;
        }
    }
    private Map<String,Node> nodes = new HashMap<>();
    public void addNode(String label){
        nodes.putIfAbsent(label,new Node(label));
    }
    public void addEdge(String from,String to,int weight){
        var fromNode = nodes.get(from);
        if(fromNode==null)
            throw new IllegalArgumentException();

        var toNode = nodes.get(to);
        if(toNode==null)
            throw new IllegalArgumentException();

        fromNode.addEdge(toNode,weight);
        toNode.addEdge(fromNode,weight);
    }

    //Implementation of Dijkstra Algorithm
    private class NodeEntry{
        private Node node;
        private int priority;
        public NodeEntry(Node node, int priority) {
            this.node = node;
            this.priority = priority;
        }
    }
    public int getShortestDistance(String from,String to){
        PriorityQueue<NodeEntry> queue = new PriorityQueue<>(
                Comparator.comparingInt(ne->ne.priority)
        );
        return 0;
    }

    public void print(){
        for(var node:nodes.values()){
            var edges = node.getEdges();
            if(!edges.isEmpty())
                System.out.println(node + " is connected to " + edges);
        }
    }
}
