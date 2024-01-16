import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        String[] arr = str.split("");
        for(String s : arr) {
            left.push(s);
        }

        for(int i=0; i<N; i++){
            String s = br.readLine();
            char ch = s.charAt(0);

            switch (ch){
                case 'L':
                    if(!left.isEmpty())
                        right.push(left.pop());
                    break;
                case 'D':
                    if(!right.isEmpty())
                        left.push(right.pop());
                    break;
                case 'B':
                    if(!left.isEmpty())
                        left.pop();
                    break;
                case 'P':
                    left.push(String.valueOf(s.charAt(2)));
                    break;
                default:
                    break;
            }
        }

        while(!left.isEmpty())
            right.push(left.pop());

        while(!right.isEmpty())
            bw.write(right.pop());

        bw.flush();
        bw.close();
    }
}
