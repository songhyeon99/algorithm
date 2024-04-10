import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int N;
    static int K;
    static int[] arr = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        
        bfs(N);
    }

    public static void bfs(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        arr[n] = 1;

        while (!queue.isEmpty()){
            int index = queue.poll();
            if(index == K) {
                System.out.println(arr[K]-1);
                return;
            }

            if(index - 1 >= 0 && arr[index-1] == 0) {
                arr[index-1] = arr[index] + 1;
                queue.add(index - 1);
            }
            if(index + 1 < 100001 && arr[index+1] == 0){
                arr[index+1] = arr[index] + 1;
                queue.add(index + 1);
            }

            if(index * 2 < 100001 && arr[index*2] == 0){
                arr[index*2] = arr[index] + 1;
                queue.add(index * 2);
            }
        }
    }

}
