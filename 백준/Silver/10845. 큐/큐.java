import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();

        Queue<Integer> queue = new LinkedList();
        int N = sc.nextInt();
        int last = 0;
        for(int i=0; i<N; i++){
            String command = sc.next();

            switch (command){
                case "push" :
                    last = sc.nextInt();
                    queue.add(last);
                    break;
                case "pop" :
                    if(queue.isEmpty())
                        sb.append(-1).append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty":
                    if(queue.isEmpty())
                        sb.append(1).append("\n");
                    else sb.append(0).append("\n");
                    break;
                case "front":
                    if(queue.isEmpty())
                        sb.append(-1).append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back":
                    if(queue.isEmpty())
                        sb.append(-1).append("\n");
                    else sb.append(last).append("\n");
                    break;
                default:
                    break;
            }
        }
        System.out.println(sb);
    }
}
