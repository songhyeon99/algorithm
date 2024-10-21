import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static String[] ver = {"BWBWBWBW", "WBWBWBWB"};
	static char[][] board;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		int result = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				result = Math.min(result, getMinCount(i,j));
			}
		}

		System.out.println(result);
	}

	static int getMinCount(int y, int x) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = y + i;
			for (int j = 0; j < 8; j++) {
				int col = x + j;
				if(board[row][col] != ver[row%2].charAt(j)){
					count++;
				}
			}
		}
		return Math.min(count, 64-count);
	}
}