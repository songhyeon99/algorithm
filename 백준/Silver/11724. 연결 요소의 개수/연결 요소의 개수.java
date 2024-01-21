import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new boolean[N+1][N+1];
        visited = new boolean[N+1];

        for(int i=0; i<M; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = map[b][a] = true;
        }
        count = 0;

        for(int i=1;i<=N;i++){
            if(visited[i]==false){
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static int N, M;
    static boolean[][] map;
    static boolean[] visited;
    static int count;
    static void dfs(int index){

        if(visited[index] == true) {
            return;
        }else{
            visited[index] = true;
            for (int i = 1; i <= N; i++) {
                if (map[index][i] == true) {
                    dfs(i);
                }
            }
        }
    }
}
