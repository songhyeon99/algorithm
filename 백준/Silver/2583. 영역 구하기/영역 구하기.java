import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int M, N, K, count, area = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] map;
    static List<Integer> width = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();

        map = new boolean [M][N];
        visited = new boolean[M][N];

        for(int i = 0; i<K ; i++){
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for(int y = y1 ; y < y2; y++){
                for(int x = x1; x<x2; x++){
                    map[y][x] = true;
                }
            }
        }

        for(int i=0 ; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && !map[i][j]) {
                    count = 1;
                    bfs(i, j);
                    width.add(count);
                    area++;
                }
            }
        }
        Collections.sort(width);
        System.out.println(area);

        for(int w : width){
            System.out.print(w+ " ");
        }

    }

    public static void bfs(int y, int x){
        visited[y][x] = true;

        for(int i =0; i<4; i++){
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if(newX >= 0 && newY >= 0 && newX < N && newY < M && !visited[newY][newX] && !map[newY][newX]){
                bfs(newY, newX);
                count++;
            }
        }
    }
}
