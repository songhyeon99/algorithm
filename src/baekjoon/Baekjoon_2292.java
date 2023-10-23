package baekjoon;

import java.util.*;


public class Baekjoon_2292 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int range = 2;
        int num=sc.nextInt();
        int count=1;

        if(num==1){
            System.out.println("1");
        }else{
            while(range<=num){
              range = range+(6*count);
              count++;
            }
            System.out.println(count);
        }


    }


}

