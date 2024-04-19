import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static int N, K, count = 0;
    static Integer[] coin;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        coin = new Integer[N];
        for(int i =0; i<N; i++){
            coin[i] = sc.nextInt();
        }

        Arrays.sort(coin, Collections.reverseOrder());

        for(int i=0; i<N; i++){
            if(K < coin[i]) continue;
             count += K / coin[i];
             K = K % coin[i];
        }

        System.out.println(count);
    }

}
