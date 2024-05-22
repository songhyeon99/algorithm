import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int count = 0;

		int[] arrA = new int[N];
		int[] arrB = new int[M];

		Map<Integer, Boolean> A = new HashMap<>();
		Map<Integer, Boolean> B = new HashMap<>();

		for(int i = 0; i<N; i++){
			int n = sc.nextInt();
			A.put(n, true);
			arrA[i] = n;
		}

		for(int i = 0; i<M; i++){
			int n = sc.nextInt();
			B.put(n, true);
			arrB[i] = n;
		}

		for(int i = 0; i<N; i++){
			if(B.get(arrA[i]) != null && B.get(arrA[i])){
				continue;
			}else{
				count++;
			}
		}

		for(int i = 0; i<M; i++){
			if(A.get(arrB[i]) != null && A.get(arrB[i])){
				continue;
			}else{
				count++;
			}
		}

		System.out.println(count);
	}
}
