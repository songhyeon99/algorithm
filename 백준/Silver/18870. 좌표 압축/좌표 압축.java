import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] sortArr = new int[N];
		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i<N; i++){
			arr[i] = sortArr[i] = sc.nextInt();
		}

		sortArr = Arrays.stream(sortArr).distinct().toArray();
		Arrays.sort(sortArr);

		for(int i = 0; i< sortArr.length; i++ ) {
			if(!map.containsKey(sortArr[i])){
				map.put(sortArr[i], i);
			}
		}

		StringBuilder sb = new StringBuilder();
		for(Integer i : arr){
			sb.append(map.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}