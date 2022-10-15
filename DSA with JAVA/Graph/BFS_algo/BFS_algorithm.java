import java.util.*;

public class BFS_algorithm {
                                 // Using BFS algorithm in Directed graph.............
    static ArrayList<Integer>[] arr;
    BFS_algorithm(int vertices){
        arr=new ArrayList[vertices];
        for(int i=0;i<vertices;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
    }
    void bfs(int vertices){                     //<<----- Beginning of algorithm
        int[] visited = new int[vertices];
        Arrays.fill(visited, 0);
        Queue<Integer> q = new LinkedList<>();

        q.add(0);
        visited[0]=1;

        while(!q.isEmpty()){
            int pic = q.remove();
            System.out.print(pic+" ");
            for(int x:arr[pic]){
                if(visited[x]==0){
                    q.add(x);
                    visited[x]=1;
                }
            }
        }
    }                                        //<<----- End of algorithm

    public static void main(String[] args) {
        System.out.print("Enter the number of vertices present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int vertices = sc.nextInt();
        BFS_algorithm graph =  new BFS_algorithm(vertices);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(1,3);
        graph.insert(2,3);
        graph.insert(3,0);

        graph.bfs(vertices);
    }
}
