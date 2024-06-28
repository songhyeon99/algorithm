import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, K, X;
	static int[] result;
	static List<List<Integer>> list;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		result = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.get(a).add(b);
		}

		bfs();

		boolean found = false;
		for (int i = 0; i < result.length; i++) {
			if (result[i] == K) {
				System.out.println(i);
				found = true;
			}
		}

		if (!found) {
			System.out.println(-1);
		}
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList();
		queue.add(X);
		visited[X] = true;
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i : list.get(current)) {
				if (!visited[i]) {
					visited[i] = true;
					result[i] = result[current] + 1;
					queue.add(i);
				}
			}
		}
	}
}