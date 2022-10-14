import java.util.Arrays;
import java.util.Scanner;

public class DisjointUnionSet {           // Union by Rank.
    int[] parent,rank;
    int n;
    DisjointUnionSet(int n){
        this.n=n;
        this.parent=new int[n];
        this.rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
        }

        Arrays.fill(rank,0);
    }

    int find(int x){
        if(parent[x]==x){
            return x;
        }
        return (find(parent[x]));
    }
    void union(int x, int y){
        int xroot = find(x);
        int yroot = find(y);

        if(xroot==yroot)
            return;

        if(rank[xroot]<rank[yroot])
            parent[xroot]=yroot;
        else if(rank[xroot]>rank[yroot])
            parent[yroot]=xroot;
        else {
            parent[xroot] = yroot;
            rank[yroot]=rank[yroot]+1;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of nodes- ");
        int n=sc.nextInt();
        DisjointUnionSet graph = new DisjointUnionSet(n);

        graph.union(0,1);
        graph.union(2,3);
        graph.union(4,5);
        graph.union(0,2);
        graph.union(2,4);
    }
}
