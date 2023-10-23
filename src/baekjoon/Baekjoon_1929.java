package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Baekjoon_1929 {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

       // boolean prime = true;
        boolean[] arr = new boolean[num2+1];
        //Arrays.fill(arr,false);

        for(int i=2;i<=num2;i++){
            if(arr[i]) continue;
                for (int j = 2; j *i <= num2; j++) {
                    arr[i * j] = true;
                    //break;
                }

        }
        arr[0]=arr[1]=true;
        for(int i=num1;i<=num2;i++){
            if(arr[i]==false)
                System.out.println(i);
        }


    }
}
