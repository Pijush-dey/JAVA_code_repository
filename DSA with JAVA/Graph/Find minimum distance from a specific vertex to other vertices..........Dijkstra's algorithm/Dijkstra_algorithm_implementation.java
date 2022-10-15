import java.util.*;

public class Dijkstra_algorithm_implementation {

                         // Here I use Directed Weighted Graph.................
    ArrayList<Vertex>[] arr;
    int[] ans;
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

    Dijkstra_algorithm_implementation(List<Edge> edge, int vertices) {
        this.arr = new ArrayList[vertices];
        for (int i = 0; i < vertices; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Edge x : edge) {
            arr[x.src].add(new Vertex(x));
        }
    }

    void dijkstra_algorithm(int vertices, int S){             // this algorithm is use for finding the minimum spanning tree

        PriorityQueue<Vertex> q = new PriorityQueue<>();
        boolean[] visited = new boolean[vertices];
        this.ans = new int[vertices];

        Arrays.fill(visited,false);
        Arrays.fill(ans,1000000);

        q.add(new Vertex(new Edge(S,S,0)));
        ans[S]= 0;

        while(!q.isEmpty()){
            Vertex node = q.remove();
            int u = node.des;
            visited[u]=true;

            ArrayList<Vertex> adj = arr[u];

            for(Vertex node1:adj){
                if(visited[node1.des]==false){
                    if(ans[node1.des]>ans[u]+node1.weight){
                        ans[node1.des]=ans[u]+node1.weight;
                    }
                    q.add(new Vertex(new Edge(node.des,node1.des,node1.weight)));
                }
            }
        }
    }

    void display(){
        for (int i=0;i< ans.length;i++){
            System.out.print(i+"- ");
            System.out.print(ans[i]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of vertices present in the Graph:- ");
        int vertices = sc.nextInt();
        System.out.println();
        System.out.print("Enter the value of vertex- ");
        int S = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 6),new Edge(0,3,1),new Edge(1,0,3), new Edge(1, 2, 7), new Edge(2, 0, 5), new Edge(2, 1, 4), new Edge(3, 2, 2),new Edge(2,3,1),new Edge(3,0,2));
        Dijkstra_algorithm_implementation graph = new Dijkstra_algorithm_implementation(edge, vertices);

        graph.dijkstra_algorithm(vertices,S);

        graph.display();
    }
}
