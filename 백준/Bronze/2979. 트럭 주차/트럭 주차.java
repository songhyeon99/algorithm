import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

		int[] arr = new int[100];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < 3; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			min = Math.min(start, min);
			max = Math.max(end, max);

			for (int j = start; j < end; j++) {
				arr[j]++;
			}
		}

		for (int i = min; i < max; i++) {
			switch (arr[i]) {
				case 1:
					sum += A * arr[i];
					break;
				case 2:
					sum += B * arr[i];
					break;
				case 3:
					sum += C * arr[i];
					break;
			}
		}

		System.out.println(sum);
	}
}