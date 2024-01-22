import java.util.*;

public class Main {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static String[] map;
    static int N, count;
    static boolean[][] visited;
    static List<Integer> result = new ArrayList<>();
    static void dfs(int x, int y){
        count++;
        visited[x][y] = true;
        for(int i=0; i<4; i++){
            int newX = dx[i] + x;
            int newY = dy[i] + y;

            if(newX >= 0 && newY >= 0 && newX < N && newY < N){
                if(map[newX].charAt(newY)=='1' && !visited[newX][newY]){
                    dfs(newX, newY);
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        map = new String[N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
                map[i] = sc.next();
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i].charAt(j) == '1' && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        Collections.sort(result);
        for(int i=0; i<result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
