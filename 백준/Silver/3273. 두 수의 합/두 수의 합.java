import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		int N = sc.nextInt();
		int[] arr = new int[N+1];

		for(int i = 1; i<=N; i++){
			arr[i] = sc.nextInt();
		}
		int X = sc.nextInt();
		Arrays.sort(arr);

		int left = 1;
		int right = N;

		while(left < right){
			int n = arr[left]+arr[right];
			if(n == X){
				count++;
				left++;
				right--;
			}else if(n > X){
				right--;
			}else{
				left++;
			}
		}
		System.out.println(count);
	}
}