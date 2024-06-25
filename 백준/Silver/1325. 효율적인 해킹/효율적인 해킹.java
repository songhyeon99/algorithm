import java.io.*;
import java.util.*;

public class Main {

	static int N, M, max;
	static List<List<Integer>> list;
	static boolean[] visited;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		result = new int[N + 1];
		visited = new boolean[N + 1];
		list = new ArrayList<>();
		max = Integer.MIN_VALUE;

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list.get(a).add(b);
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];
			dfs(i);
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(result[i], max);
		}

		for (int i = 1; i <= N; i++) {
			if (max == result[i]) {
				sb.append(i+" ");
			}
		}
		System.out.println(sb);;
	}

	public static void dfs(int n) {
		visited[n] = true;
		for (int i : list.get(n)) {
			if(!visited[i]) {
				result[i]++;
				dfs(i);
			}
		}
	}
}