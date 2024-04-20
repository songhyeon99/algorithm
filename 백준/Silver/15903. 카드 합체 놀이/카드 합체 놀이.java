import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N, M;
    static long sum = 0;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);

        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(input2[i]);
        }

        for (int i = 0; i < M; i++) {
            Arrays.sort(arr);
            long temp = arr[0] + arr[1];
            arr[0] = arr[1] = temp;
        }

        for (int i = 0; i < N; i++) {
            sum += arr[i];
        }
        bw.write(Long.toString(sum));
        bw.flush();
        br.close();
        bw.close();
    }
}
