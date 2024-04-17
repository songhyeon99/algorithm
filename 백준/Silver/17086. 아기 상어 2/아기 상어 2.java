import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N, M, count, max = 0;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) continue;
                visited = new boolean[N][M];
                max = Math.max(bfs(i, j), max);
            }
        }
        System.out.println(max);
    }

    static int bfs(int y, int x) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(y, x, 0));
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();
            for (int i = 0; i < 8; i++) {
                int newX = currentPosition.x + dx[i];
                int newY = currentPosition.y + dy[i];
                int dis = currentPosition.distance;

                if (newX >= 0 && newY >= 0 && newX < M && newY < N) {
                    if (map[newY][newX] == 1) {
                        return dis + 1; // 상어를 찾은 경우 거리 반환
                    }
                }

                if (newX >= 0 && newY >= 0 && newX < M && newY < N && !visited[newY][newX]) {
                    queue.add(new Position(newY, newX, dis + 1));
                    visited[newY][newX] = true;
                }
            }
        }
        return 0;
    }

    static class Position {

        int x, y, distance;

        public Position(int y, int x, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
