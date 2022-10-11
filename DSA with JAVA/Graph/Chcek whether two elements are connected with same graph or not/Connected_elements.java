import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Connected_elements {
                                     //..........To solve this problem, we will use DFS Algo.
    static ArrayList<Integer>[] arr;
    static int[] graph_num;
    static int count=0;
    Connected_elements(int nodes){
        arr=new ArrayList[nodes];
        for(int i=0;i<nodes;i++) {
            arr[i] = new ArrayList<>();
        }
    }
    void insert(int x, int y){
        arr[x].add(y);
    }
    void dfs(int nodes){                    //<<----- Beginning of algorithm
        int[] visited = new int[nodes];
        this.graph_num=new int[nodes];

        Arrays.fill(visited, 0);

        for(int i=0;i<nodes;i++){
            if(visited[i]==0){
                dfs1(i,visited);
                count++;
            }
        }
    }
    void dfs1(int i,int[] visited){
        visited[i]=1;
        graph_num[i]=count;
        System.out.print(i+" ");
        for(int x:arr[i]){
            if(visited[x]==0){
                dfs1(x,visited);
            }
        }
    }                                    //<<----- End of algorithm

    boolean check_connection(int x, int y){
        if(graph_num[x]==graph_num[y])
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.print("Enter the number of nodes present in the Graph:- ");
        Scanner sc = new Scanner (System.in);
        int nodes = sc.nextInt();
        Connected_elements  graph =  new Connected_elements (nodes);
        graph.insert(0,1);
        graph.insert(1,2);
        graph.insert(1,3);
        graph.insert(2,3);
        graph.insert(3,0);

        graph.insert(4,5);
        graph.insert(5,6);
        graph.insert(6,7);

        graph.dfs(nodes);

        System.out.println();
        System.out.println("Enter the first number");
        int num1=sc.nextInt();
        System.out.println("Enter the second number");
        int num2=sc.nextInt();
        System.out.println("The two numbers are connected within a graph- "+graph.check_connection(num1,num2));
    }
}
