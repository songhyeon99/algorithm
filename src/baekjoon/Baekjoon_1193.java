package baekjoon;

import java.util.*;

public class Baekjoon_1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int i=1;
        while(num>i){
            num-=i;
            i++;
        }

        if(i%2==1){
            System.out.println((i+1-num)+"/"+num);
        }else{
            System.out.println(num+"/"+(i+1-num));
        }
    }
}
