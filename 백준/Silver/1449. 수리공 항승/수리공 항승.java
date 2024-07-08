import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		if (L == 1) {
			System.out.println(N);
			return;
		}

		int count = 1, result = 0;
		for (int i = 1; i < N; i++) {
			if (Math.abs(arr[i] - arr[i - 1]) <= (L - count)) {
				count += Math.abs(arr[i] - arr[i - 1]);
			} else {
				result++;
				count = 1;
			}
		}
		if(count > 0) result++;
		System.out.println(result);
	}
}