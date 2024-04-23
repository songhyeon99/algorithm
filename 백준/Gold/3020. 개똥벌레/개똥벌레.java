import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, H;
    static int[] bottom, top, sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        H = sc.nextInt();
        bottom = new int[H + 1];
        top = new int[H + 1];
        sum = new int[H + 1];

        for (int i = 0; i < N; i++) {
            if ((i + 2) % 2 == 0) {
                bottom[sc.nextInt()]++;
            } else {
                top[sc.nextInt()]++;
            }
        }

        for (int i = H - 1; i >= 1; i--) {
            bottom[i] += bottom[i + 1];
            top[i] += top[i + 1];
        }

        sum[1] = bottom[1];
        sum[H] = top[1];

        for (int i = 2; i <= H - 1; i++) {
            sum[i] = bottom[i] + top[H - i + 1];
        }

        Arrays.sort(sum);

        long min = sum[1];
        int left = 1, right = H;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (sum[mid] <= min) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(sum[1] + " " + right);
    }
}