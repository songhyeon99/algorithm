import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N];
		
		for(int i = 0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		if(N % 2 == 0){
			System.out.println(Math.abs(arr[N/2]-arr[N/2-1])+1);
		}else{
			System.out.println(1);
		}
	}
}