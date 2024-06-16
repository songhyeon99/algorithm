import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		String str = st.nextToken();
		String s = "";
		String ss = "";
		int[] alpha = new int[26];
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			int index = currentChar - 'a';
			if (alpha[index] == 0) {
				alpha[index]++;
				s += currentChar;
			} else {
				count++;
			}
		}

		s += String.valueOf(4 + count);
		s = String.valueOf(1906 + N) + s;

		for (int i = s.length() - 1; i >= 0; i--) {
			ss += s.charAt(i);
		}

		ss = "smupc_" + ss;

		System.out.println(ss);
	}
}