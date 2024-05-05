import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] map;
	static int[][] result;
	static boolean[][] visited;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		result = new int[N][M];
		visited = new boolean[N][M];
		Position startPosition = new Position();

		for(int i = 0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2){
					startPosition = new Position(i,j);
				}
			}
		}

		bfs(startPosition.x, startPosition.y);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					System.out.print("-1 ");
				} else {
					System.out.print(result[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	static void bfs(int x, int y){
		Queue<Position> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.add(new Position(x,y));

		while(!queue.isEmpty()) {
			Position current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];

				if (newX >= 0 && newY >= 0 && newX < N && newY < M && map[newX][newY] == 1 && !visited[newX][newY]) {
					queue.add(new Position(newX, newY));
					visited[newX][newY] = true;
					result[newX][newY] = result[current.x][current.y] + 1;
				}
			}
		}
	}

	static class Position {
		int x, y;
		public Position(){}
		public Position(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}