import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int count = 0;

		if (N == K) {
			System.out.println(0);
			return;
		}
		while (N >= K) {
			int bottles = 0;
			int temp = N;
			while (temp > 0) {
				if (temp % 2 == 1) {
					bottles++;
				}
				temp /= 2;
			}
			if(bottles <= K){
				break;
			}
			count++;
			N++;
		}
		System.out.println(count);
	}
}