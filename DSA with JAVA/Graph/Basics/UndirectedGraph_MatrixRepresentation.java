import java.util.Arrays;
import java.util.Scanner;

public class UndirectedGraph_MatrixRepresentation {
    static int edges;
    static int arr[][];
    UndirectedGraph_MatrixRepresentation(int nodes){
        this.arr=new int[nodes][nodes];
        for(int[] row:arr){
            Arrays.fill(row,0);
        }
    }
    void insert(int x, int y){
        arr[x][y]=1;
        arr[y][x]=1;
        edges++;
    }
    void display(int nodes,int[][] arr){
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
        UndirectedGraph_MatrixRepresentation graph =  new UndirectedGraph_MatrixRepresentation(nodes);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(2,3);
        graph.insert(3,0);
        System.out.println("In the Graph, no. of nodes- "+nodes+ " & no. of edges- "+edges);

        graph.display(nodes,arr);
    }
}
