import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, x1, y1, x2, y2;
	static boolean[][] visited;
	static int dx[] = {1, 1, -1, -1, 2, 2, -2, -2};
	static int dy[] = {2, -2, 2, -2, 1, -1, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int I = Integer.parseInt(st.nextToken());

		for (int i = 0; i < I; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			visited = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			System.out.println(bfs(x1, y1));
		}
	}

	static int bfs(int x, int y) {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(x, y, 0));

		while (!queue.isEmpty()) {
			Position current = queue.poll();

			if (current.x == x2 && current.y == y2) {
				return current.count;
			}

			for (int i = 0; i < dx.length; i++) {
				int newX = dx[i] + current.x;
				int newY = dy[i] + current.y;

				if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY]) {
					queue.add(new Position(newX, newY, current.count + 1));
					visited[newX][newY] = true;
				}
			}
		}
		return -1;
	}

	static class Position {
		int x, y, count;

		public Position(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}