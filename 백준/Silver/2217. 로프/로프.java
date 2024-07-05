import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		Integer[] arr = new Integer[N];

		for(int i = 0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, Collections.reverseOrder());
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<N; i++){
			max = Math.max(max, arr[i] * (i+1));
		}
		System.out.println(max);
	}
}