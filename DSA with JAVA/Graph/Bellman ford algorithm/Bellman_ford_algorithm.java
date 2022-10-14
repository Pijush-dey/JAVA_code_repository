import java.util.*;

public class Bellman_ford_algorithm {

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
    static class Node{
        int des, weight;
        Node(Edge edge) {
            this.des = edge.des;
            this.weight = edge.weight;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of nodes present in the Graph:- ");
        int nodes = sc.nextInt();
        System.out.println();
        System.out.print("Enter the number of nodes present in the Graph:- ");
        int S = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0, 1, 3),new Edge(0,2,1),new Edge(1,2,-8), new Edge(1, 2, 7), new Edge(2, 3, 2), new Edge(3, 1, 4));
        Bellman_ford_algorithm graph = new Bellman_ford_algorithm(edge, nodes);
    }
}
