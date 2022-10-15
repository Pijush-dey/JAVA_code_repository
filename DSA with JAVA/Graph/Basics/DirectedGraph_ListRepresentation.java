import java.util.ArrayList;
import java.util.Scanner;

public class DirectedGraph_ListRepresentation {
    static int edges;
    static ArrayList<Integer>[] arr;
    DirectedGraph_ListRepresentation(int vertices){
        arr=new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
        edges++;
    }
    void display(int vertices,ArrayList<Integer>arr[]){
        for(int i=0;i<vertices;i++){
            System.out.print(i+": ");
            for(int x:arr[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int vertices = sc.nextInt();
        DirectedGraph_ListRepresentation graph =  new DirectedGraph_ListRepresentation(vertices);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(1,3);
        graph.insert(2,3);
        graph.insert(3,0);
        System.out.println("In the Graph, no. of vertices- "+vertices+ " & no. of edges- "+edges);

        graph.display(vertices,arr);
    }
}
