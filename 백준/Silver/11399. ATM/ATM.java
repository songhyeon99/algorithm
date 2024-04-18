import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, sum;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        sum = 0;
        N = sc.nextInt();
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
        }
        System.out.println(sum);
    }
}
