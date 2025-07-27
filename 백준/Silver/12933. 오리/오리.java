import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        if (str.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        int[] count = new int[5];
        int max = 0;

        for (char ch : str.toCharArray()) {
            int idx = "quack".indexOf(ch);

            if (idx == 0) {
                if (count[4] > 0) count[4]--;
                count[0]++;
            } else {
                if (count[idx - 1] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[idx - 1]--;
                count[idx]++;
            }

            int ongoing = 0;
            for (int i = 0; i < 4; i++) ongoing += count[i];
            max = Math.max(max, ongoing);
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] != 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(max);
    }
}
