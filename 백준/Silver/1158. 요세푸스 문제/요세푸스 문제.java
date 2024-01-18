import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Queue queue = new LinkedList();

        int N = sc.nextInt();
        int K = sc.nextInt();

        for(int i = 1; i <= N; i++){
            queue.add(i);
        }
        System.out.print("<");
        while(queue.size() != 1){
            for(int i = 0; i < K-1; i++){
                queue.add(queue.poll());
            }
            System.out.print(queue.poll()+", ");
        }
        System.out.print(queue.poll()+">");
        }
    }

