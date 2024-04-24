import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int max = 0;
        int N = sc.nextInt();
        long[] sum = new long[N + 1];
        Map<Integer, Integer> indexs = new HashMap<>();
        Map<Long, Integer> count = new HashMap<>();

        long result = 0;
        for (int i = 1; i <= N; i++) {
            int value = sc.nextInt();
            sum[i] = sum[i-1] + value;

            if(!indexs.containsKey(value)) indexs.put(value, i);

            long total = sum[i] - sum[indexs.get(value) - 1];
            count.put(total, count.getOrDefault(total, 0) + 1);

            result = Math.max(result, total);
        }

        System.out.println(result +" "+count.get(result));
    }
}