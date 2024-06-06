import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] arrN = new int[N];
		int[] arrM = new int[N];

		int result = 0;

		for(int i = 0; i<N-1; i++){
			arrM[i] = sc.nextInt();
		}

		for(int i = 0; i<N; i++){
			arrN[i] = sc.nextInt();
		}

		int min = arrN[0];
		result = min * arrM[0];
		for(int i = 1; i<N-1; i++){
			if(arrN[i] < min){
				min = arrN[i];
			}
			result += min * arrM[i];
		}
		System.out.println(result);
 	}
}