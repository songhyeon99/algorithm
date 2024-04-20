import java.util.Scanner;

public class Main {

    static char[][] A;
    static char[][] B;
    static int N, M, count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        A = new char[N][M];
        B = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                A[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                B[i][j] = s.charAt(j);
            }
        }

        if (N < 3 || M < 3) {
            if (isSameProcession()) {
                System.out.println("0");
            } else {
                System.out.println("-1");
            }
            return;
        }

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (A[i][j] != B[i][j]) {
                    changeProcession(i, j);
                    count++;
                }
            }
        }

        if(isSameProcession()){
            System.out.println(count);
        }else{
            System.out.println("-1");
        }
    }

    static void changeProcession(int i, int j) {
        for (int k = i; k < i + 3; k++) {
            for (int l = j; l < j + 3; l++) {
                if (A[k][l] == '0') {
                    A[k][l] = '1';
                } else {
                    A[k][l] = '0';
                }
            }
        }
    }

    static boolean isSameProcession() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
