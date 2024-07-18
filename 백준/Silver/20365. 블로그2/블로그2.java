import java.util.Scanner;

public class Main {
	static String str;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		sc.nextLine();
		str = sc.nextLine();

		System.out.println(Math.min(paint('B'), paint('R')));
	}

	static int paint(char C) {
		int count = 1;
		for (int i = 0; i < N-1; i++) {
			if (str.charAt(i) == C && str.charAt(i + 1) != C) {
				count++;
			}
		}

		if(str.charAt(N-1) == C){
			count++;
		}
		return count;
	}
}