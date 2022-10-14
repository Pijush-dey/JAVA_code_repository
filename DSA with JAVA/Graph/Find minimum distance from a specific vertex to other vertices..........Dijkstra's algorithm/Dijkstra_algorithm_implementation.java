import java.util.*;

public class Dijkstra_algorithm_implementation {

                         // Here I use Directed Weighted Graph.................
    ArrayList<Node>[] arr;
    int[] ans;
    static class Edge {
        int src, des, weight;
        Edge(int src, int des, int weight) {
            this.src = src;
            this.des = des;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node>{
        int des, weight;
        Node(Edge edge) {
            this.des = edge.des;
            this.weight = edge.weight;
        }
        public int compareTo(Node that){
            return this.weight-that.weight;
        }
    }

    Dijkstra_algorithm_implementation(List<Edge> edge, int nodes) {
        this.arr = new ArrayList[nodes];
        for (int i = 0; i < nodes; i++) {
            arr[i] = new ArrayList<>();
        }
        for (Edge x : edge) {
            arr[x.src].add(new Node(x));
        }
    }

    void dijkstra_algorithm(int nodes, int S){             // this algorithm is use for finding the minimum spanning tree

        PriorityQueue<Node> q = new PriorityQueue<>();
        boolean[] visited = new boolean[nodes];
        this.ans = new int[nodes];

        Arrays.fill(visited,false);
        Arrays.fill(ans,1000000);

        q.add(new Node(new Edge(S,S,0)));
        ans[S]= 0;

        while(!q.isEmpty()){
            Node node = q.remove();
            int u = node.des;
            visited[u]=true;

            ArrayList<Node> adj = arr[u];

            for(Node node1:adj){
                if(visited[node1.des]==false){
                    if(ans[node1.des]>ans[u]+node1.weight){
                        ans[node1.des]=ans[u]+node1.weight;
                    }
                    q.add(new Node(new Edge(node.des,node1.des,node1.weight)));
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

        System.out.print("Enter the number of nodes present in the Graph:- ");
        int nodes = sc.nextInt();
        System.out.println();
        System.out.print("Enter the value of vertex- ");
        int S = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 6),new Edge(0,3,1),new Edge(1,0,3), new Edge(1, 2, 7), new Edge(2, 0, 5), new Edge(2, 1, 4), new Edge(3, 2, 2),new Edge(2,3,1),new Edge(3,0,2));
        Dijkstra_algorithm_implementation graph = new Dijkstra_algorithm_implementation(edge, nodes);

        graph.dijkstra_algorithm(nodes,S);

        graph.display();
    }
}
