import java.util.Scanner;

public class Main {
	static String[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String[] str = new String[N];
		boolean[] alpha = new boolean[26];

		next : for (int i = 0; i < N; i++) {
			str[i] = sc.nextLine();
			boolean inserted = false;
			int current;
			arr = str[i].split(" ");

			for (int j = 0; j < arr.length; j++) {
				char c = Character.toLowerCase(arr[j].charAt(0));
				current = c - 'a';
				if (!alpha[current]) {
					alpha[current] = true;
					inserted = true;
					makeWord(j, 0);
					break;
				}
			}

			if (!inserted) {
				for (int j = 0; j < arr.length; j++) {
					for (int l = 0; l < arr[j].length(); l++) {
						char c = Character.toLowerCase(arr[j].charAt(l));
						current = c - 'a';
						if (!alpha[current]) {
							alpha[current] = true;
							inserted = true;
							makeWord(j, l);
							continue next;
						}
					}
				}
			}

			if (!inserted) {
				System.out.println(str[i]);
			}
		}
	}

	static void makeWord(int wIdx, int aIdx) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (i == wIdx && j == aIdx) {
					sb.append("[").append(arr[i].charAt(j)).append("]");
				} else {
					sb.append(arr[i].charAt(j));
				}
			}
			sb.append(" ");
		}
		System.out.println(sb);
	}
}