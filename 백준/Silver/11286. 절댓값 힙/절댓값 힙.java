import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((q1, q2) -> {
            int first = Math.abs(q1);
            int second = Math.abs(q2);

            if(first==second){
                if(q1>q2) return 1;
                else return -1;
            }else{
                return first-second;
            }
        });
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        for(int i=0; i<N; i++){
            int num = sc.nextInt();
            if(num<0 || num>0){
                queue.add(num);
            }else if(num==0){
                if(queue.isEmpty()){
                    System.out.println("0");
                }else{
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
