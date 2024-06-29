import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, count = 0;
	static int[][] map;
	static boolean[][] top;
	static boolean[][] visited;
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		map = new int[N][M];
		top = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0 && top[i][j] == false) {
					bfs(i, j);
				}
			}
		}
		System.out.println(count);
	}

	static void bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		visited = new boolean[N][M];

		queue.add(new Position(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			for (int i = 0; i < 8; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny]) {
					if (map[nx][ny] > map[current.x][current.y])
						return;
					else if (map[nx][ny] == map[current.x][current.y]) {
						queue.add(new Position(nx, ny));
						top[nx][ny] = true;
					}
					visited[nx][ny] = true;
				}
			}
		}
		count++;
	}

	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}