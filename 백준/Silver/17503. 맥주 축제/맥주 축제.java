import java.util.*;
import java.io.*;

public class Main {
public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] arr = new int[K][2];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
    
		Arrays.sort(arr, Comparator.comparingInt(a -> a[1]));

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int prefSum = 0;
		int answer = -1;
    
		for (int i = 0; i < K; i++) {
			pq.add(arr[i][0]);
			prefSum += arr[i][0];

			if (pq.size() > N) {
				prefSum -= pq.poll();
			}

			if (pq.size() == N && prefSum >= M) {
				answer = arr[i][1];
				break;
			}
		}

		System.out.println(answer);
	}
}
