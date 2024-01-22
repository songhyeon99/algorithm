import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int W, H, count;
    static int[] dx = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<8; i++){
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if(newX >= 0 && newY >= 0 && newX < H && newY < W){
                if(map[newX][newY] == 1 && !visited[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            W = sc.nextInt();
            H = sc.nextInt();

            if(W == 0 && H == 0) break;

            map = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            count=0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
