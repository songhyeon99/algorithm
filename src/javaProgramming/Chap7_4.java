package javaProgramming;
import java.util.Iterator;
import java.util.Scanner;
import java.util.*;
import static javaProgramming.Rain.print;
class Rain{
    static void print(Vector<Integer>v){
        int sum=0;
        Iterator<Integer> it = v.iterator();
        while(it.hasNext()){
            int n = it.next();
            System.out.print(n+ " ");
            sum+=n;
        }
        System.out.println();
        System.out.println("현재 평균" + sum/v.size());
    }}
public class Chap7_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> v= new Vector<Integer>();
       while(true){
           System.out.println("강수량 입력(0 입력시 종료)>>");
           int n = sc.nextInt();
           if(n==0) break;
           v.add(n);
           print(v);
       }
    }
}

