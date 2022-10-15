import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Topological_sort {
                          // We implement Kahn's algorithm using BFS...
                          // Here, we sue Directed Graph
    static ArrayList<Integer>[] arr;
    static int[] inDegree;
    Topological_sort(int vertices){
        arr=new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
    }
    void display(int vertices){
        this.inDegree = new int[vertices];
        for (int i=0;i<vertices;i++){
            for (int x:arr[i])
                inDegree[x]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i=0;i<vertices;i++){
            if(inDegree[i]==0)
                q.add(i);
        }
        while (!q.isEmpty()){
            int pic = q.remove();
            System.out.print(pic+" ");
            for(int e : arr[pic]){
                if(--inDegree[e]==0)
                    q.add(e);
            }
        }
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int vertices = sc.nextInt();
        Topological_sort graph =  new Topological_sort(vertices);
        graph.insert(3,1);
        graph.insert(3,2);
        graph.insert(1,2);
        graph.insert(2,0);

        System.out.println("Topological sort is-- ");
        graph.display(vertices);
    }
}
