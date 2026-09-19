import java.util.*;
public class Bfs {
    int v;
    int adjMatrix[][];
    boolean visited[];
    @SuppressWarnings("unused")
    Bfs(int v){
        this.v=v;
        adjMatrix = new int[v][v];
       visited= new boolean[v];
    }
    public void BFS_Traverse(int start){
        Arrays.fill(visited,false);
        Queue<Integer> q= new LinkedList<>();
        q.add(start);
        visited[start]=true;
        while(!q.isEmpty()){
            int w=q.poll();
            System.out.println(w+" "+" ");
            for (int i = 0; i < v; i++) {
                if(!visited[i] && adjMatrix[w][i]==1)
                {
                    q.add(i);
                  visited[i]=true;

                }
            }
        }

            
    }
    public static void main(String[] args) {
       @SuppressWarnings("resource")
       Scanner sc= new Scanner(System.in);
       int start;
       System.out.print("Enter the no of vertices:");
       int v=sc.nextInt();
       Bfs obj= new Bfs(v);
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                obj.adjMatrix[i][j]=sc.nextInt();
            }
            
        }
        System.out.print("enter starting vertex for BFS:");
        start= sc.nextInt();
        obj.BFS_Traverse(start);
    }
}