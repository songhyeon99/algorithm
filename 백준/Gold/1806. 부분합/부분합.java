import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int S = sc.nextInt();
		int min = Integer.MAX_VALUE;
		int[] arr = new int[N+1];

		for(int i = 0; i<N; i++){
			arr[i] = sc.nextInt();
		}

		int left = 0;
		int right = 0;
		int sum = 0;
		while(left <= N && right <= N){
			if(sum < S) {
				sum += arr[right];
				right++;
			}else{
				sum -= arr[left];
				min = Math.min(min, right-left);
				left++;
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? 0 : min);
	}
}