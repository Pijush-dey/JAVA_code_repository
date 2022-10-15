import java.util.*;

public class Graph_with_neg_edge {
    ArrayList<Vertex>[] arr;
    int[] dis;
    static class Edge {
        int src, des, weight;
        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }
    static class Vertex{
        int des, weight;
        Vertex(Edge edge) {
            this.des = edge.des;
            this.weight = edge.weight;
        }
    }
    Graph_with_neg_edge(List<Edge> edge, int vertices) {
        this.arr = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Edge x : edge) {
            arr[x.src].add(new Vertex(x));
        }
    }
    boolean detect_negative_cycle(int vertices, List<Edge> edge){     // Here, I am using Bellman Ford algorithm
        this.dis = new int[vertices];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;

        for (int i=0;i<vertices-1;i++){
            for (Edge e :edge){
                if(dis[e.src] != Integer.MAX_VALUE && dis[e.src]+e.weight < dis[e.des])
                    dis[e.des] = dis[e.src]+e.weight;
            }
        }
        for (int i=0;i<vertices-1;i++){
            for (Edge e :edge){
                if(dis[e.src] != Integer.MAX_VALUE && dis[e.src]+e.weight < dis[e.des])
                    return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices present in the Graph:- ");
        int vertices = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 3),new Edge(0,2,1),new Edge(1,2,-8), new Edge(2, 3, 2), new Edge(3, 1, 4));
        Graph_with_neg_edge graph = new Graph_with_neg_edge(edge, vertices);

        System.out.println("There is a negative cycle in the graph:- "+graph.detect_negative_cycle(vertices,edge));
    }
}
