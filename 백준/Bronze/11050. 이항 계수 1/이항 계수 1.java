import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(fact(N) / (fact(N - K) * fact(K)));
	}

	static int fact(int n) {
		int result = 1;
		for(int i = 1; i<=n; i++){
			result *= i;
		}
		return result;
		// if (n == 1) {
		// 	return 1;
		// }
		// return n * fact(n - 1);
	}
}