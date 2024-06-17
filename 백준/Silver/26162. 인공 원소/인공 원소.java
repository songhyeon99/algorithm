import java.util.Scanner;

public class Main {
    static final int LIMIT = 120;
    static int[] a;
    static boolean[] prime = new boolean[LIMIT];
    static String[] ans;

    public static void solve(int i) {
        for (int j = 2; j < LIMIT; j++) {
            for (int k = 2; k < LIMIT; k++) {
                if (j + k != a[i]) continue;
                if (!prime[j] && !prime[k]) {
                    ans[i] = "Yes";
                    return;
                }
            }
        }
        ans[i] = "No";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        a = new int[N];
        ans = new String[N];

        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }

        // 소수 배열 초기화
        for (int i = 2; i < LIMIT; i++) {
            int j = i;
            while (i * j < LIMIT) {
                prime[i * j] = true;
                j++;
            }
        }

        // 소수 초기화: prime[i]가 false이면 소수임
        for (int i = 2; i < LIMIT; i++) {
            if (!prime[i]) {
                for (int j = 2 * i; j < LIMIT; j += i) {
                    prime[j] = true;
                }
            }
        }

        // 각 숫자에 대해 두 소수의 합으로 표현 가능한지 확인
        for (int i = 0; i < N; i++) {
            solve(i);
        }

        // 결과 출력
        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }

        sc.close();
    }
}