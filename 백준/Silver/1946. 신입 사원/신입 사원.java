import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for(int i = 0; i<n; i++){
			int num = Integer.parseInt(br.readLine());
			int[][] arr = new int[num][2];
			for(int j = 0; j<num; j++){
			StringTokenizer st = new StringTokenizer(br.readLine());
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			System.out.println(newEmployee(num, arr));
		}
	}

	public static int newEmployee(int n, int[][] arr){
		int count = 0;
		Arrays.sort(arr, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		int min = arr[0][1];
		for(int i = 1;i<n;i++){
			if(min > arr[i][1]) {
				count++;
				min = arr[i][1];
			}
		}
		return count+1;
	}
}
