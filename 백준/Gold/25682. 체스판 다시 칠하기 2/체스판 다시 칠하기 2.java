import java.util.Scanner;

public class Main {
	static int N, M, K;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();
		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		System.out.println(Math.min(getMinBoard('B'), getMinBoard('W')));
	}

	static int getMinBoard(char c){
		int min = Integer.MAX_VALUE;
		int[][] sum = new int[N+1][M+1];
		int value;

		for(int i = 0; i<N; i++){
			for(int j = 0; j<M; j++){
				if((i+j) % 2 == 0){
					value = map[i][j] != c ? 1 : 0;
				}else{
					value = map[i][j] == c ? 1 : 0;
				}
				sum[i+1][j+1] = sum[i][j+1] + sum[i+1][j] - sum[i][j] + value;
			}
		}

		for (int i = 1; i <= N - K + 1; i++) {
			for (int j = 1; j <= M - K + 1; j++) {
				min = Math.min(min,
					sum[i + K - 1][j + K - 1] - sum[i + K - 1][j - 1] - sum[i - 1][j + K - 1] + sum[i - 1][j - 1]);
			}
		}
		return min;
	}
}