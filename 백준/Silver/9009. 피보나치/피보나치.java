import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	private static int sum = 0;
	private static int index =3;
	private static int[] arr = new int[10000000];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr[0] = 0; arr[1] = 1; arr[2] = 1;

		for(int i = 0; i<n; i++) {
			int value = Integer.parseInt(br.readLine());
						List<Integer> ans = fibonacci(value);
			for (int num : ans) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

	private static List<Integer> fibonacci(int n) {
		int resultSum = 0;
		List<Integer> result = new ArrayList<>();

		for (int i = index; sum <= n; i++, index++) {
			int value = arr[i - 1] + arr[i - 2];
			if (n >= value) {
				arr[i] = value;
				sum = value;
			}
			if(value > n) {
				index--;
				break;
			}
		}

		resultSum = 0;
		for(int i = index; i>=0; i--){
			int temp = resultSum;
			temp += arr[i];
			if(temp <= n){
				result.add(arr[i]);
				resultSum = temp;
				if(resultSum == n) break;
			}
		}
		Collections.sort(result);
		return result;
	}
}