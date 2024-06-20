import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];

		for(int i =0; i<N;i++){
			arr[i] = sc.nextInt();
		}


		int count = 0;
		int sum = 0;
		int left = 0;
		int right = 0;
		while(true){
			if(sum >= M){
				sum -= arr[left];
				left++;
			}else if(right == N){
				break;
			}else{
				sum += arr[right];
				right++;
			}
			if(sum == M){
				count++;
			}
		}

		System.out.println(count);
	}
}