import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int D = sc.nextInt();
		int K = sc.nextInt();
		int C = sc.nextInt();

		int count = 0;
		int[] arr = new int[N];
		int[] sushi = new int[D + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < K; i++) {
			if (sushi[arr[i]] == 0) {
				count++;
			}
			sushi[arr[i]]++;
		}

		int max = count;
		if (sushi[C] == 0) {
			max++;
		}
		for (int i = 1; i < N; i++) {
			int left = (i - 1) % N;
			int right = (i + K - 1) % N;

			if (sushi[arr[left]] > 1) {
				sushi[arr[left]]--;
			} else {
				sushi[arr[left]]--;
				count--;
			}

			if (sushi[arr[right]] == 0) {
				count++;
			}
			sushi[arr[right]]++;
			if (sushi[C] == 0) {
				max = Math.max(max, count + 1);
			} else {
				max = Math.max(max, count);
			}
		}
		System.out.println(max);
	}
}