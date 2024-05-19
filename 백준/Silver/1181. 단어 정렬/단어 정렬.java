import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();

		String[] strArr = new String[N];

		for (int i = 0; i < N; i++) {
			strArr[i] = sc.nextLine();
		}

		Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return o1.length() - o2.length();
				}
			}
		});

		System.out.println(strArr[0]);
		for (int i = 1; i < N; i++) {
			if (!strArr[i].equals(strArr[i - 1])) {
				System.out.println(strArr[i]);
			}
		}
	}
}