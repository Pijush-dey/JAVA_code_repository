import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DetectCycle_UndirectedGraph {
    static ArrayList<Integer>[] arr;
    DetectCycle_UndirectedGraph(int vertices){
        arr=new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
    }
    boolean cycle_detect(int vertices){                    //<<----- Beginning of algorithm
        int[] visited = new int[vertices];
        Arrays.fill(visited, 0);

        for(int i=0;i<vertices;i++){
            if(visited[i]==0){
                if(dfs(i,visited,-1))
                    return true;
            }
        }
        return false;
    }
    boolean dfs(int i,int[] visited,int parent){
        visited[i]=1;
        for(int x:arr[i]){
            if(visited[x]==0){
                if(dfs(x,visited,parent))
                    return true;
            }
            else if(x!=parent)
                return true;
        }
        return false;
    }                                    //<<----- End of algorithm

    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int vertices = sc.nextInt();
        DetectCycle_UndirectedGraph  graph =  new DetectCycle_UndirectedGraph (vertices);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(2,3);
        graph.insert(3,4);

        System.out.println("There is a cycle in the graph or not- "+graph.cycle_detect(vertices));
    }
}
