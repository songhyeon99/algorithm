import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int[] h = new int[1000001];
		int arrow = 0;

		for(int i = 0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 0; i<n; i++) {
			int tempH = arr[i];
			if(h[tempH] <= 0) {
				arrow++;
				tempH -= 1;
				h[tempH]++;
			}else{
				h[tempH]--;
				tempH -= 1;
				h[tempH]++;
			}
		}

		System.out.println(arrow);
	}
}
