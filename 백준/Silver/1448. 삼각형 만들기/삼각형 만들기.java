import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 2; i < N; i++) {
			int a = arr[i];
			int b = arr[i - 1];
			int c = arr[i - 2];

			if (a < b + c && b < a + c && c < a + b) {
				max = Math.max(max, a + b + c);
			}
		}

		System.out.println(max != Integer.MIN_VALUE ? max : -1);
	}
}