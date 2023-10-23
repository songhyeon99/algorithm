package baekjoon;

import java.util.*;
public class Baekjoon_10250 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int count = 1;
        int H, W, N;
        for (int i = 0; i < T; i++) {
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();

            int n1=(N/H)+1;
            int n2=N%H;

            if(n2==0){
                n1=N/H;
                n2=H;

            }
            System.out.println(n2+"0"+n1);
        }
    }

}
