import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M, K, count, max;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static boolean[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        max=0;
        visited = new boolean[N][M];
        map = new boolean[N][M];

        for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x-1][y-1] = true;
        }

        for(int i = 0;i<N;i++){
            for(int j=0; j<M;j++){
                if(map[i][j] && !visited[i][j]){
                    count = 0;
                    bfs(i,j);
                    max = Math.max(count, max);
                }
            }
        }
        System.out.println(max+1);
    }

    static void bfs(int x, int y){
        Queue<Position> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Position(x, y));

        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = dx[i] + currentPosition.x;
                int newY = dy[i] + currentPosition.y;

                if (newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newX][newY] && map[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.add(new Position(newX, newY));
                    count++;
                }
            }
        }
    }

    static class Position{
        int x, y;

        public Position(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
