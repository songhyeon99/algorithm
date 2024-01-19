import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        arr = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            arr[a][b] = arr[b][a] = 1;
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println();
        visited = new boolean[N+1];
        bfs(V);

    }

    static Queue<Integer> queue = new LinkedList();
    static int[][] arr;
    static boolean[] visited;
    static int N;
    static int V;
    static int M;

    static public void dfs(int start){
        visited[start] = true;
        System.out.print(start+" ");

        if(start == arr.length) return;

        for(int i=1; i<arr.length; i++){
            if(visited[i]==false && arr[start][i] == 1){
                dfs(i);
            }
        }
    }

    static public void bfs(int start){
        visited[start] = true;
        queue.add(start);

        System.out.print(start + " ");

        while (!queue.isEmpty()){
            int num = queue.poll();

            for(int i=1; i<arr.length; i++){
                if(visited[i] == false && arr[num][i]==1){
                    visited[i] = true;
                    queue.add(i);
                    System.out.print(i+" ");
                }
            }
        }
    }
}
