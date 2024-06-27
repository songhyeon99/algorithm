import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int count = 1;
			int[][] arr = new int[N][2];
			boolean[] visited = new boolean[N];

			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr, (o1, o2) -> {
				return o1[0] - o2[0];
			});

			int min = arr[0][1];
			for (int j = 1; j < N; j++) {
				if (min > arr[j][1]) {
					count++;
					min = arr[j][1];
				}
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}