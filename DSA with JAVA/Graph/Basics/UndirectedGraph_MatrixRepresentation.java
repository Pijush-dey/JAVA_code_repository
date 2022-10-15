import java.util.Arrays;
import java.util.Scanner;

public class UndirectedGraph_MatrixRepresentation {
    static int edges;
    static int arr[][];
    UndirectedGraph_MatrixRepresentation(int Vertices){
        this.arr=new int[Vertices][Vertices];
        for(int[] row:arr){
            Arrays.fill(row,0);
        }
    }
    void insert(int x, int y){
        arr[x][y]=1;
        arr[y][x]=1;
        edges++;
    }
    void display(int Vertices,int[][] arr){
        for(int i=0;i<Vertices;i++){
            System.out.print(i+": ");
            for(int x:arr[i]){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of Vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int Vertices = sc.nextInt();
        UndirectedGraph_MatrixRepresentation graph =  new UndirectedGraph_MatrixRepresentation(Vertices);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(2,3);
        graph.insert(3,0);
        System.out.println("In the Graph, no. of Vertices- "+Vertices+ " & no. of edges- "+edges);

        graph.display(Vertices,arr);
    }
}
