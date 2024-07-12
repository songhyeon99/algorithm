import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			long result = 0, maxPrice = 0;

			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}

			for(int j = N-1; j >= 0; j--){
				if(arr[j] >= maxPrice){
					maxPrice = arr[j];
				}else{
					result += Math.abs(maxPrice - arr[j]);
				}
			}
			System.out.println(result);
		}
	}
}