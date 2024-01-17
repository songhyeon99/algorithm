import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());
        int i = 0;

        for (int j = 0; j < N; j++) {
            String str = br.readLine();
            String command = str.split(" ")[0];
            if (command.equals("push")) {
                i = Integer.parseInt(str.split(" ")[1]);
                queue.add(i);
            } else if (command.equals("pop")) {
                Integer num = queue.poll();
                if(num == null) sb.append(-1).append("\n");
                else sb.append(num).append("\n");
            } else if (command.equals("size")) {
                sb.append(queue.size()).append("\n");
            } else if (command.equals("empty")) {
                if(queue.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            } else if (command.equals("front")) {
                if(queue.size() == 0) sb.append(-1).append("\n");
                else sb.append(queue.peek()).append("\n");
            } else if (command.equals("back")) {
                if(queue.size() == 0) sb.append(-1).append("\n");
                else sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

}
