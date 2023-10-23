package baekjoon;

import java.util.*;
public class Baekjoon_10870 {
    static int Fibo(int n){
        if(n==0) return 0;
        else if(n==1) return 1;
        return Fibo(n-1)+Fibo(n-2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(Fibo(n));
    }
}
