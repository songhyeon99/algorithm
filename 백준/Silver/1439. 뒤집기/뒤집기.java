import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 0;
		String S = sc.next();
		boolean[] arr = new boolean[S.length()];

		for(int i = 0; i<S.length(); i++){
			arr[i] = S.charAt(i) =='0' ? true : false;
		}
		boolean prev = arr[0];
		for(int i = 1; i<S.length(); i++){
			if(arr[i] != arr[i-1]){
				if(prev != arr[i]){
					count++;
				}
				prev = arr[i];
				arr[i] = !arr[i];
			} else {
				prev = arr[i];
			}
		}
		System.out.println(count);
	}
}