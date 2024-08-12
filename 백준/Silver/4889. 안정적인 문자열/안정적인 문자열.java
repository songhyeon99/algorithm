import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = 1;
		while (true) {
			Stack<String> stack = new Stack<>();
			String str = br.readLine();
			if (str.charAt(0) == '-') {
				break;
			}
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '{') {
					stack.add("{");
				} else {
					if (stack.isEmpty()) {
						stack.add("{");
						count++;
					} else {
						stack.pop();
					}
				}
			}
			if (!stack.isEmpty()) {
				count += stack.size()/2;
			}
			sb.append(t++).append(". ").append(count).append("\n");
		}
		System.out.print(sb);
	}
}