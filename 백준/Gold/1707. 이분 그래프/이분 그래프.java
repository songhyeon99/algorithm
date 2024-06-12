import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V, E;
	static boolean result;
	static boolean[] visited;
	static int[] color;
	static List<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList[V + 1];
			for (int j = 1; j <= V; j++) {
				graph[j] = new ArrayList<>();
			}

			for (int j = 0; j < E; j++) {
				st = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				graph[u].add(v);
				graph[v].add(u);
			}

			color = new int[V + 1];
			result = true;
			for (int j = 1; j <= V; j++) {
				if (color[j] == 0 && result) {
					bfs(j);
				}
			}
			bw.write(result ? "YES\n" : "NO\n");

			bw.flush();
		}
	}

	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		color[start] = 1;
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (int neighbor : graph[current]) {
				if (color[neighbor] == color[current]) {
					result = false;
					break;
				}
				if (color[neighbor] == 0 && color[neighbor] != color[current]) {
					color[neighbor] = (color[current] == 1) ? 2 : 1;
					queue.add(neighbor);
				}
			}
		}
	}
}