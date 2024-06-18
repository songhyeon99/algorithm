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
		Long[] arr = new Long[N];
		Long min = Long.MAX_VALUE;


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(arr);

		int left = 0;
		int right = N - 1;
		int resultL = 0, resultR = 0;
		while (left < right) {
			Long sum = arr[left] + arr[right];
			if (Math.abs(sum) < Math.abs(min)) {
				min = sum;
				resultL = left;
				resultR = right;
			}
			if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(arr[resultL]).append(" ").append(arr[resultR]);
		System.out.println(sb);
	}
}