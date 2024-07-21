import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N+1];
		List<Integer> result = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}

		for(int i = N; i>=1; i--){
			result.add(arr[i], i);
		}
		for(int i : result){
			System.out.print(i + " ");
		}
	}
}