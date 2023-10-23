package baekjoon;
import java.util.*;

public class Baekjoon_1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            int j;
            for (j=2; j < arr[i]; j++) {
                if (arr[i] % j == 0) {
                    break;
                }
            }
            if(j==arr[i]){
                count++;
            }
        }
        System.out.println(count);

    }}

