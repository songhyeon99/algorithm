import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());

			if(N == 1){
				System.out.println(1);
			}else if(N == 2){
				System.out.println(2);
			}else if(N == 3){
				System.out.println(4);
			}else {
				int[] dp = new int[N + 1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;

				for (int j = 4; j <= N; j++) {
					dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
				}
				System.out.println(dp[N]);
			}
		}
	}
}