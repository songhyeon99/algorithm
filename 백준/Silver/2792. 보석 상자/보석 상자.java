import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int left = 1, right = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[M];

        for (int i = 0; i < M; i++) {
            arr[i] = sc.nextInt();
            right = Math.max(arr[i], right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int count = 0;
            for (int i = 0; i < M; i++) {
                if(arr[i] < mid) count++;
                else count += (arr[i] + mid -1) / mid;
            }

            if (count > N) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(left);
    }
}