import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("0.#");

		int N = sc.nextInt();
		Integer[] arr = new Integer[N];

		for(int i = 0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr, Collections.reverseOrder());

		double result = arr[0];

		for(int i = 1; i<N; i++){
			result += ((double)arr[i]/2);
		}
		System.out.println(df.format(result));
	}
}