import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int size = 0;

		for (int i = 0; i < N; i++) {
			if ((int)Math.pow(2, i) >= N) {
				size = (int)Math.pow(2, i);
				break;
			}
		}

		if(size == N){
			System.out.println(size + " " + 0);
			return;
		}

		int count = 1;
		int temp = size / 2;
		int tempSize = size / 2;
		while (true) {
			if (tempSize < N) {
				count++;
				temp = temp / 2;
				if (tempSize + temp <= N) {
					tempSize += temp;
					if (tempSize == N) {
						break;
					}
				}
			}
		}
		System.out.println(size + " " + count);
	}
}