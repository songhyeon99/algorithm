package baekjoon;

import java.util.*;
public class Baekjoon_9020 {
    public static void get_prime(){
        arr[0]=arr[1]=true;
        for(int i=2;i<=arr.length;i++){
            for(int j=2;j*i<arr.length;j++){
                arr[j*i]=true;
            }
        }
    }
    public static boolean[] arr = new boolean[10001];
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    get_prime();
    int T = sc.nextInt();
    for(int i=0;i<T;i++){
        int n = sc.nextInt();
        int p = n/2;
        int q = n/2;
        while(true){
            if(arr[p]==false&&arr[q]==false){
                System.out.println(p+" "+q);
                break;
            }
            p--;
            q++;
        }
    }

    }
}
