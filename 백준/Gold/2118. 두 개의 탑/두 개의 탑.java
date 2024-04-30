import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N + 1];
        int result = 0, sum = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        for (int start = 1; start <= N; start++) {
            int right = 0, left = 0, compare = 0;
            for (int end = start; end <= N; end++) {
                right += arr[end];
                left = sum - right;
                compare = Math.min(right, left);
                result = Math.max(result, compare);
            }
        }
        System.out.println(result);
    }
}