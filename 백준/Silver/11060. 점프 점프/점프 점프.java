import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		if (N == 1) {
			System.out.println("0");
		} else {
			bfs();
		}
	}

	static void bfs() {
		Queue<Position> queue = new LinkedList<>();
		queue.add(new Position(arr[0], 0, 0));
		visited[0] = true;
		int count = 0;

		while (!queue.isEmpty()) {
			Position current = queue.poll();
			for (int i = 1; i <= current.distance; i++) {
				if (current.idx + i == N - 1) {
					System.out.println(current.count + 1);
					return;
				}
				if (arr[current.idx + i] != 0 && !visited[current.idx + i]) {
					queue.add(new Position(arr[current.idx + i], current.idx + i, current.count + 1));
					visited[current.idx + i] = true;
				}
			}
		}
		System.out.println("-1");
	}

	static class Position {
		int distance, idx, count;

		public Position(int distance, int idx, int count) {
			this.distance = distance;
			this.idx = idx;
			this.count = count;
		}
	}
}