import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Integer[][] arr = new Integer[N][2];

		for(int i = 0; i < 2; i++){
			for(int j = 0; j <N; j++){
				arr[j][i] = sc.nextInt();
			}
		}

		Arrays.sort(arr, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				return o2[1] - o1[1];
			}
		});

		long sum = arr[0][0];
		long temp = 0;
		for(int i = 1; i<N; i++){
			temp += arr[i-1][1];
			sum += arr[i][0] + temp;
		}
		System.out.println(sum);
	}
}