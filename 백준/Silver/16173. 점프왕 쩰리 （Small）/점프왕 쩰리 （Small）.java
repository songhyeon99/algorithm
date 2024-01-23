import java.util.Scanner;

public class Main {
    static int N;
    static boolean result;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int[][] map;
    static boolean[][] visited;
    static void dfs(int x, int y){

        if(map[x][y]==-1) {
            result = true;
        }

        if(!visited[x][y]) {
            visited[x][y] = true;
            if (map[x][y] + x < N) {
                dfs(map[x][y] + x, y);
            }

            if (map[x][y] + y < N) {
                dfs(x, map[x][y] + y);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        visited = new boolean[N][N];
        map = new int[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                map[i][j] = sc.nextInt();
            }
        }

        dfs(0,0);

        if(result) System.out.println("HaruHaru");
        else System.out.println("Hing");
    }
}
