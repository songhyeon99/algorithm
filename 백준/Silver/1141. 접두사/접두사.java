import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String[] str = new String[n];
		boolean[] isPrefix = new boolean[n];

		for (int i = 0; i < n; i++) {
			str[i] = br.readLine();
		}

		Arrays.sort(str);

		for (int i = 0; i < n; i++) {
			String prefix = str[i];
			for (int j = i + 1; j < n; j++) {
				if (!isPrefix[j] && prefix.length() <= str[j].length()) {
					if(prefix.equals(str[j].substring(0, prefix.length()))) {
						isPrefix[i] =true;
					}
				}
			}
		}

		for(int i = 0; i<n; i++){
			if(!isPrefix[i]){
				count++;
			}
		}
		System.out.println(count);
	}
}