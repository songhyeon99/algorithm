import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int i = 0; i<T; i++) {
			int N = sc.nextInt();
			Character[] C = new Character[N];
			List<Character> result = new ArrayList<>();

			sc.nextLine();
			for (int j = 0; j < N; j++) {
				C[j] = sc.next().charAt(0);
			}

			result.add(C[0]);
			Character first = C[0];
			for (int j = 1; j < N; j++) {
				if (first - 'A' < C[j] - 'A') {
					result.add(C[j]);
				} else {
					result.add(0, C[j]);
					first = C[j];
				}
			}

			for (Character j : result) {
				System.out.print(j);
			}
			System.out.println();
		}
	}
}