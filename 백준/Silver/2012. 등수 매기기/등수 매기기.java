import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		long[] arr = new long[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}

		Arrays.sort(arr);

		long sum = 0;
		for (int i = 0; i < N; i++) {
			sum += Math.abs((i+1) - arr[i]);
		}
		System.out.println(sum);
	}
}