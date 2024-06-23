import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();

		for (int i = 0; i < T; i++) {
			String str = sc.nextLine();
			if (isPalindrome(str)) {
				System.out.println(0);
			} else if (isPseudoPalindrome(str)) {
				System.out.println(1);
			} else {
				System.out.println(2);
			}
		}
		sc.close();
	}

	public static boolean isPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;
	}

	public static boolean isPseudoPalindrome(String str) {
		int left = 0;
		int right = str.length() - 1;
		boolean changed = false;

		while (left < right) {
			if (str.charAt(left) != str.charAt(right)) {
				if (!changed) {
					// Check by removing one character either from the left or the right
					return isPalindrome(str.substring(left + 1, right + 1)) ||
						isPalindrome(str.substring(left, right));
				} else {
					return false;
				}
			}
			left++;
			right--;
		}
		return true;
	}
}