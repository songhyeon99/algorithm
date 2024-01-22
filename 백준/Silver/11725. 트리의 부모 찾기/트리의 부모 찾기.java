import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N;
    static int[] parent;
    static boolean[] visited;
    static List<Integer> list[];

    static void dfs(int index){
        visited[index] = true;

        for(int i : list[index]){
            if(!visited[i]){
                parent[i] = index;
                dfs(i);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        list = new ArrayList[N+1];
        parent = new int[N+1];
        visited = new boolean[N+1];

        for(int i=0; i<=N;i++){
            list[i] = new ArrayList<>();
        }

        for(int i=1; i<N; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            list[a].add(b);
            list[b].add(a);
        }

        dfs(1);

        for(int i=2; i<parent.length; i++) {
            System.out.println(parent[i]);
        }
    }
}
