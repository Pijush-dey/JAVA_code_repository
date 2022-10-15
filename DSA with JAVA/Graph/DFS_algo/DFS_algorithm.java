import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DFS_algorithm {
                                // Using DFS algorithm in Directed graph.............
    static ArrayList<Integer>[] arr;
    DFS_algorithm(int vertices){
        arr=new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
    }
    void dfs(int vertices){                    //<<----- Beginning of algorithm
        int[] visited = new int[vertices];
        Arrays.fill(visited, 0);

        for(int i=0;i<vertices;i++){
            if(visited[i]==0){
                dfs1(i,visited);
            }
        }
    }
    void dfs1(int i,int[] visited){
        visited[i]=1;
        System.out.print(i+" ");
        for(int x:arr[i]){
            if(visited[x]==0){
                dfs1(x,visited);
            }
        }
    }                                    //<<----- End of algorithm

    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int vertices = sc.nextInt();
        DFS_algorithm  graph =  new DFS_algorithm (vertices);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(1,3);
        graph.insert(2,3);
        graph.insert(3,0);

        graph.dfs(vertices);
    }
}
