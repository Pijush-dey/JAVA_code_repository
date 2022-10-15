import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DirectedWeightedGraph_ListRepresentation {

    ArrayList<Vertex>[] arr;
    static class Edge{
        int src,des,weight;
        Edge(int src, int des, int weight){
            this.src=src;
            this.des=des;
            this.weight=weight;
        }
    }
    static class Vertex{
        int des,weight;
        Vertex(Edge edge){
            this.des=edge.des;
            this.weight=edge.weight;
        }
    }
    DirectedWeightedGraph_ListRepresentation(List<Edge> edge, int Vertices){
        this.arr = new ArrayList[Vertices];
        for(int i=0;i<Vertices;i++){
            arr[i]= new ArrayList<>();
        }
        for(Edge x:edge){
            arr[x.src].add(new Vertex(x));
        }
    }
    void display(int Vertices){
        for(int i=0;i<Vertices;i++){
            System.out.print(i+": ");
            for (Vertex node:arr[i]){
                System.out.print(node.des+"("+node.weight+")"+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of Vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);                 // here, it will be- 6
        int Vertices = sc.nextInt();
        List<Edge> edge = Arrays.asList(new Edge(0,1,6),new Edge(1,2,7),new Edge(2,0,5),new Edge(2,1,4),new Edge(3,2,0),new Edge(4,5,1),new Edge(5,4,3));
        DirectedWeightedGraph_ListRepresentation graph = new DirectedWeightedGraph_ListRepresentation(edge, Vertices);

        graph.display(Vertices);
    }
}
