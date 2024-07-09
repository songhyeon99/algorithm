import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			int[] newArr = new int[N];
			int max = Integer.MIN_VALUE;

			for(int j = 0; j<N; j++){
				arr[j] = sc.nextInt();
			}

			Arrays.sort(arr);

			int index1 = 0, index2 = N-1;
			for(int j = 0; j<N; j++){
				if((j+2)%2 == 0){
					newArr[index1] = arr[j];
					index1++;
				}else{
					newArr[index2] = arr[j];
					index2--;
				}
			}
			for(int j = 1; j<N; j++){
				max = Math.max(max, Math.abs(newArr[j] - newArr[j-1]));
			}
			System.out.println(max);
		}
	}
}