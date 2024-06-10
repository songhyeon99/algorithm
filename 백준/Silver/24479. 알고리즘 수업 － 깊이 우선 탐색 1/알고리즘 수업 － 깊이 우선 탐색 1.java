import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

		for (int i = 1; i <= N; i++) {
			Collections.sort(list.get(i));
		}

		dfs(R);

		for (int i = 1; i < order.length; i++) {
			System.out.println(order[i]);
		}
	}

	static void dfs(int r) {
		visited[r] = true;
		order[r] = count++;

		for (int next : list.get(r)) {
			if (!visited[next]) {
				dfs(next);
			}
		}
	}
}