import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextInt();
        long Y = sc.nextInt();
        int ratio = (int) (Y * 100 / X);

        if (ratio >= 99) {
            System.out.println(-1);
        } else {
            int left = 0;
            int right = Integer.MAX_VALUE;
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((int) ((Y + mid) * 100 / (X + mid)) > ratio) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(left);
        }
    }
}
