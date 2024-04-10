import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int count;
    static int[][] map;
    static boolean[][] flag;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        flag = new boolean[N][M];
        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(map[N-1][M-1]);
    }

    public static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x, y));
        flag[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if (newX < 0 || newY < 0 || newX >= N || newY >= M) {
                    continue;
                }
                if (map[newX][newY] == 0 || flag[newX][newY]) {
                    continue;
                }
                if (map[newX][newY] == 1 && flag[newX][newY] == false) {
                    queue.add(new Point(newX, newY));
                    flag[newX][newY] = true;
                    map[newX][newY] = map[point.x][point.y] + 1;
                }
            }
        }
    }

    public static class Point {

        int x, y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
