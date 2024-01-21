import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int j=0; j<T; j++) {
            count = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            map = new boolean[M][N];
            visited = new boolean[M][N];
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[x][y] = true;
            }

            for(int x=0; x<M; x++){
                for(int y=0; y<N; y++){
                    if(map[x][y] == true && !visited[x][y]) {
                        dfs(x, y);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int M, N, K;
    static boolean[][] map;
    static boolean[][] visited;
    static int count;
    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int newX = dx[i]+x;
            int newY = dy[i]+y;

            if(newX < 0 || newY < 0 || newX >= M || newY >=N) continue;
            if(newX >= 0 && newY >= 0 && newX < M && newY < N) {
                if (map[newX][newY] == true && !visited[newX][newY]) {
                    dfs(newX, newY);
                }
            }
        }
    }
}
