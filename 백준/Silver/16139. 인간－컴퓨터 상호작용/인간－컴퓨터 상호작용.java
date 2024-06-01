import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int Q = sc.nextInt();
		int[] sum = new int[str.length() + 1];

		for (int i = 0; i < Q; i++) {
			String c = sc.next();
			int start = sc.nextInt();
			int end = sc.nextInt();
			int count = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == c.charAt(0)) {
					count++;
					sum[j] = count;
				}else{
					sum[j] = count;
				}
			}
			if(start == 0) {
				System.out.println(sum[end]);
			}else {
				System.out.println(sum[end] - sum[start - 1]);
			}
		}
	}
}