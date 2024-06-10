import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M, R, count = 1;
	static List<List<Integer>> list;
	static boolean[] visited;
	static int[] order;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();

		list = new ArrayList<>();
		visited = new boolean[N + 1];
		order = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			list.get(a).add(b);
			list.get(b).add(a);
		}

		for (int i = 0; i < list.size(); i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}

		bfs(R);

		for (int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}

	static void bfs(int r) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(r);

		while (!queue.isEmpty()) {
			int n = queue.poll();
			if (!visited[n]) {
				visited[n] = true;
				order[n] = count++;

				for (int next : list.get(n)) {
					queue.add(next);
				}
			}
		}
	}
}