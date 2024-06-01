import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		String str = br.readLine();
		int Q = Integer.parseInt(br.readLine());
		int[][] alpha = new int[str.length() + 1][26];

		for (int i = 1; i <= str.length(); i++) {
			int searchChar = str.charAt(i - 1) - 'a';

			for (int j = 0; j < 26; j++) {
				int beforeValue = alpha[i - 1][j];
				alpha[i][j] = (j == searchChar ? beforeValue + 1 : beforeValue);
			}
		}

		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int findIndex = st.nextToken().charAt(0)-'a';
			int start = Integer.parseInt(st.nextToken())+1;
			int end = Integer.parseInt(st.nextToken())+1;

			bw.write((alpha[end][findIndex]-alpha[start-1][findIndex])+"\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}
}