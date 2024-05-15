import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int arr[][];
	static int result[][];
	static boolean visited[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			visited = new boolean[N];
			bfs(i);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j]+ " ");
			}
			System.out.println();
		}
	}

	static void bfs(int index) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(index);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int i = 0; i < N; i++) {
				if (!visited[i] && arr[current][i] == 1) {
					visited[i] = true;
					result[index][i] = 1;
					queue.add(i);
				}
			}
		}

	}
}