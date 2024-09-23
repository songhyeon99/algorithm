import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int count = 0;
	static int a, b;
	static boolean[] visited = new boolean[100001];
	static int[] decimal = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

		visited[0] = visited[1] = true;
		underPrime();

		for (int i = a; i <= b; i++) {
			if (!visited[decimal[i]])
				count++;
		}

		System.out.println(count);
	}

	static void underPrime() {
		for (int i = 2; i < 100001; i++) {
			if (visited[i])
				continue;
			for (int j = i + i; j < 100001; j += i) {
				visited[j] = true;
				int temp = j;
				while(temp%i == 0){
					temp/=i;
					decimal[j]++;
				}
			}
		}
	}
}