import java.util.ArrayList;
import java.util.Scanner;

public class DirectedGraph_ListRepresentation {
    static int edges;
    static ArrayList<Integer>[] arr;
    DirectedGraph_ListRepresentation(int nodes){
        arr=new ArrayList[nodes];
        for(int i=0;i<nodes;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
        edges++;
    }
    void display(int nodes,ArrayList<Integer>arr[]){
        for(int i=0;i<nodes;i++){
            System.out.print(i+": ");
            for(int x:arr[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of nodes present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int nodes = sc.nextInt();
        DirectedGraph_ListRepresentation graph =  new DirectedGraph_ListRepresentation(nodes);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(1,3);
        graph.insert(2,3);
        graph.insert(3,0);
        System.out.println("In the Graph, no. of nodes- "+nodes+ " & no. of edges- "+edges);

        graph.display(nodes,arr);
    }
}
