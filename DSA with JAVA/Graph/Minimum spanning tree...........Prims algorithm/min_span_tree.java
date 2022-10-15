import java.util.*;
                            // Here, we are using Directed Weighted Graph.
public class min_span_tree {
    ArrayList<Vertex>[] arr;
    int ans=0;
    static class Edge {
        int src, des, weight;
        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

     static class Vertex implements Comparable<Vertex>{
        int des, weight;
        Vertex(Edge edge) {
            this.des = edge.des;
            this.weight = edge.weight;
        }
        public int compareTo(Vertex that){
            return this.weight-that.weight;
        }
    }

    min_span_tree(List<Edge> edge, int vertices) {
        this.arr = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Edge x : edge) {
            arr[x.src].add(new Vertex(x));
        }
    }

    int prims_algorithm(int vertices){             // this algorithm is use for finding the minimum spanning tree

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices];
        Arrays.fill(visited,false);

        q.add(new Vertex(new Edge(0,0,0)));
        while(!q.isEmpty()){
            Vertex node = q.remove();
            int u = node.des;
            visited[u]=true;

            ans+= node.weight;

            ArrayList<Vertex> adj = arr[u];

            for(Vertex node1:adj){
                if(visited[node1.des]==false){
                    q.add(new Vertex(new Edge(node.des,node1.des,node1.weight)));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner(System.in);                 // here, it will be- 6
        int vertices = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 6),new Edge(0,3,1),new Edge(1,0,3), new Edge(1, 2, 7), new Edge(2, 0, 5), new Edge(2, 1, 4), new Edge(3, 2, 2),new Edge(2,3,1),new Edge(3,0,2));
        min_span_tree graph = new min_span_tree(edge, vertices);

        System.out.println("The length of minimum spanning tree is:- "+graph.prims_algorithm(vertices));
    }
}
