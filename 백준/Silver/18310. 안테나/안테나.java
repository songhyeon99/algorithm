import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for(int i = 0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		double midDouble = (double)N/2;
		int midIdx = (int)Math.round(midDouble);

		System.out.println(arr[midIdx-1]);
	}
}