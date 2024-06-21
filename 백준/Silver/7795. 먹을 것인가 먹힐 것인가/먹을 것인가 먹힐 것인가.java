import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			int[] A = new int[N];
			int[] B = new int[M];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[j] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				B[k] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(A);
			Arrays.sort(B);

			int count = 0;
			int j = 0;

			for (int l = 0; l < N; l++) {
				while (j < M && A[l] > B[j]) {
					j++;
				}
				count += j;
			}
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}