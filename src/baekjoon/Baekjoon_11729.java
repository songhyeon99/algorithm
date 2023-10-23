package baekjoon;

import java.util.*;
public class Baekjoon_11729 {
    public static StringBuilder sb = new StringBuilder();
    public static void Hanoi(int num, int from, int by, int to){
        if(num==1) {
            sb.append(from+" "+to+"\n");
            return;
        }
        else{
            Hanoi(num-1,from,to,by);
            sb.append(from+" "+to+"\n");
            Hanoi(num-1,by,from,to);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num=sc.nextInt();
        sb.append((int)(Math.pow(2,num)-1)).append('\n');
        Hanoi(num,1,2,3);
        System.out.println(sb);
    }
}
