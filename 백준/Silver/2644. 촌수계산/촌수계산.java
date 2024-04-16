import java.util.Scanner;

public class Main {
    static int N, P1, P2, M, depth = 0;
    static boolean[] visited;
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        P1 = sc.nextInt() -1;
        P2 = sc.nextInt() -1;
        M = sc.nextInt();

        visited = new boolean[N];
        map = new boolean[N][N];

        for(int i = 0; i<M ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            map[x-1][y-1]=map[y-1][x-1] =true;
        }

        dfs(P1, 0);
        System.out.println(-1);
    }
    static void dfs(int x, int depth){
        visited[x] = true;

        if(x == P2){
            System.out.println(depth);
            System.exit(0);
        }

        for(int i=0; i<N; i++){
            if(visited[i] || !map[x][i]) continue;
            dfs(i, depth+1);
        }
    }
}
