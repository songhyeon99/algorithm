import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Integer> stack = new Stack();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(1);
            }
            if (input.charAt(i) == ')') {
                if (input.charAt(i - 1) == '(') {
                    stack.pop();
                    sum += stack.size();
                } else {
                    stack.pop();
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }
}
