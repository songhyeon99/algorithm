import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		String result1="", result2="";
		Long min = Long.MAX_VALUE;

		for(int i = 0; i<N; i++){
			long n = sc.nextInt();
			result1 = result1.concat(String.valueOf(n));
		}

		for(int i = 0; i<N; i++){
			long n = sc.nextInt();
			result2 = result2.concat(String.valueOf(n));
		}

		min = Math.min(Long.parseLong(result1), Long.parseLong(result2));
		System.out.println(min);
	}
}