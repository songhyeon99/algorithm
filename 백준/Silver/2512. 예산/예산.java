import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        int left = 0, right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(arr[i], right);
        }

        int M = sc.nextInt();
        while (left <= right) {
            int mid = (left + right) / 2;
            int budget = 0;
            for (int i = 0; i < N; i++) {
                budget += Math.min(mid, arr[i]);
            }
            if (budget <= M) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }
}