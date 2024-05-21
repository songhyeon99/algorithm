import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String str = String.valueOf(N);
		int len = String.valueOf(N).length();
		char[] num = new char[len];

		for (int i = 0; i < len; i++) {
			num[i] = str.charAt(i);
		}

		Arrays.sort(num);

		for (int i = num.length - 1; i >= 0; i--) {
			System.out.print(num[i]);
		}
	}
}