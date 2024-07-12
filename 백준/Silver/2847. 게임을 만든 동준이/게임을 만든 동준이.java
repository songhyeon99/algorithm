import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int count = 0;
		for (int i = N - 2; i >= 0; i--) {
			if (arr[i] > arr[i + 1]) {
				count += Math.abs(arr[i+1] - arr[i]) + 1;
				arr[i] = arr[i+1] - 1;
			}
			if(arr[i] == arr[i+1]){
				arr[i] = arr[i+1] - 1;
				count++;
			}
		}

		System.out.println(count);
	}
}