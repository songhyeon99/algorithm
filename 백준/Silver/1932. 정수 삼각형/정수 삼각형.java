import java.util.Scanner;

public class Main {
	static int N, max = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		map = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dp[0][0] = map[0][0];

		for (int i = 1; i < N; i++) {
			dp[i][0] = dp[i - 1][0] + map[i][0];

			for (int j = 1; j <= i; j++) {
				int num = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
				dp[i][j] = num + map[i][j];
			}

			dp[i][i] = dp[i - 1][i - 1] + map[i][i];
		}

		for (int i = 0; i < N; i++) {
			max = Math.max(dp[N - 1][i], max);
		}
		System.out.println(max);
	}
}