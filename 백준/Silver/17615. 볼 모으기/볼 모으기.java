import java.util.Scanner;

public class Main {
	static int N;
	static String str;
	static char[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();
		arr = new char[N];

		for (int i = 0; i < N; i++) {
			arr[i] = str.charAt(i);
		}

		System.out.println(Math.min(fire('R'), fire('B')));
	}

	static int fire(char c) {
		int frontCount = 0;
		int backCount = 0;
		int frontResult = 0;
		int backResult = 0;

		for (int i = 0; i < N - 1; i++) {
			if (arr[i] == c) {
				frontCount++;
				if (arr[i + 1] != c) {
					frontResult = frontCount;
				}
			}
		}

		for (int i = N - 1; i > 0; i--) {
			if (arr[i] == c) {
				backCount++;
				if (arr[i - 1] != c) {
					backResult = backCount;
				}
			}
		}
		return Math.min(backResult, frontResult);
	}
}