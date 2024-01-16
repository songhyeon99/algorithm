import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Character> queue = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);
                if (ch == '(') {
                    queue.add(ch);
                }else{
                    if(queue.isEmpty()) {
                        queue.add(ch);
                        break;
                    }
                    else {
                        queue.poll();
                    }
                }
            }
        if(queue.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
        queue.clear();
        }
    }
}

