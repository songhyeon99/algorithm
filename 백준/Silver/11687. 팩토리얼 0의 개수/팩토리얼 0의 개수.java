import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();

        long left = 0, right = M*5;

        while (left <= right) {
            long mid = (left + right) / 2;
            if (checkCount(mid) >= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(checkCount(left) == M) {
            System.out.println(left);
        }else{
            System.out.println(-1);
        }
    }

    static int checkCount(long num) {
        int count = 0;
        for (int i = 5; i <= num; i *= 5) {
            count += num / i;
        }
        return count;
    }
}