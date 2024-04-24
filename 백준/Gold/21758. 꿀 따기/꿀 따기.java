import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1];
        int[] toRight = new int[N + 1];
        int[] toLeft = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            toRight[i] = toRight[i - 1] + arr[i];
        }

        int temp = 0;
        for (int i = N; i >= 1; i--) {
            temp += arr[i];
            toLeft[i] = temp;
        }

        // 벌통 왼쪽 고정
        int max = 0;
        for (int i = N - 1; i >= 1; i--) {
            int total = (toLeft[1] - toLeft[i]) + (toLeft[1] - toLeft[N] - arr[i]);
            max = Math.max(max, total);
        }

        // 벌통 오른쪽 고정
        for (int i = 2; i <= N; i++) {
            int total = toRight[N] - arr[1] - arr[i] + toRight[N] - toRight[i];
            max = Math.max(max, total);
        }

        // 벌을 맨 왼쪽, 오른쪽 고정 -> 벌통 위치 바꿈
        for (int i = 2; i < N; i++) {
            int total = (toLeft[i] - arr[N]) + (toRight[i] - arr[1]);
            max = Math.max(total, max);
        }
        System.out.println(max);
    }
}