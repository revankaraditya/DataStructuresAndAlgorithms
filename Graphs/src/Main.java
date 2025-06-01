public class Main {
    public static void main(String[] args) {
        var graph = new Graph();
        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addNode("D");
        graph.addNode("E");
        graph.addEdge("A","B");
        graph.addEdge("C","A");
        graph.addEdge("C","B");
        graph.addEdge("C","D");
        graph.addEdge("A","E");
        graph.addEdge("B","E");
        graph.addEdge("D","E");
        //graph.removeNode("C");
        graph.depthFirstTraversal("C");
        System.out.println();
        graph.depthFirstTraversalRecursive("C");
        System.out.println();
        graph.traverseBreadthFirst("C");
        System.out.println();
        var list = graph.topologicalSort();
        System.out.println(list);
        System.out.println(graph.hasCycle());
    }
}