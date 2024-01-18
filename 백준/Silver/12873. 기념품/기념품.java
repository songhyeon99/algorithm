import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a = 1;
        int b = 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            b = (int) ((b + Math.pow(a, 3) - 1) % list.size());
            list.remove(b);
            a++;
        }

        System.out.println(list.get(0));
    }
}
