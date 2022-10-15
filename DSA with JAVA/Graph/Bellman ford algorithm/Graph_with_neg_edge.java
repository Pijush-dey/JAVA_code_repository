import java.util.*;

public class Graph_with_neg_edge {
    ArrayList<Node>[] arr;
    int[] dis;
    static class Edge {
        int src, des, weight;
        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }
    static class Node{
        int des, weight;
        Node(Edge edge) {
            this.des = edge.des;
            this.weight = edge.weight;
        }
    }
    Graph_with_neg_edge(List<Edge> edge, int nodes) {
        this.arr = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Edge x : edge) {
            arr[x.src].add(new Node(x));
        }
    }
    boolean detect_negative_cycle(int nodes, List<Edge> edge){     // Here, I am using Bellman Ford algorithm
        this.dis = new int[nodes];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;

        for (int i=0;i<nodes-1;i++){
            for (Edge e :edge){
                if(dis[e.src] != Integer.MAX_VALUE && dis[e.src]+e.weight < dis[e.des])
                    dis[e.des] = dis[e.src]+e.weight;
            }
        }
        for (int i=0;i<nodes-1;i++){
            for (Edge e :edge){
                if(dis[e.src] != Integer.MAX_VALUE && dis[e.src]+e.weight < dis[e.des])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes present in the Graph:- ");
        int nodes = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 3),new Edge(0,2,1),new Edge(1,2,-8), new Edge(2, 3, 2), new Edge(3, 1, 4));
        Graph_with_neg_edge graph = new Graph_with_neg_edge(edge, nodes);

        System.out.println("There is a negative cycle in the graph:- "+graph.detect_negative_cycle(nodes,edge));
    }
}
