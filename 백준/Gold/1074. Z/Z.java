import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, R, C, count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int size = (int)Math.pow(2, N);
		func(size, 0, 0);
	}

	static void func(int size, int r, int c) {
		if (size == 1) {
			System.out.println(count);
			return;
		}

		int half = size / 2;
		if (R < r + half && C < c + half) {
			func(half, r, c);
		}
		if (half + r > R && half + c <= C) {
			count += (size * size) / 4;
			func(half, r, c + half);
		}
		if (half + r <= R && c + half > C) {
			count += (size * size) / 4 * 2;
			func(half, r + half, c);
		}
		if (half + r <= R && c + half <= C) {
			count += (size * size) / 4 * 3;
			func(half, r + half, c + half);
		}
	}
}