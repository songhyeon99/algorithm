package javaProgramming;

import java.util.Scanner;

interface Stack{
    int length();
    int capacity();
    String pop();
    boolean push(String str);
}

class StringStack implements Stack {
    private String[] element;
    private int tos;

    public StringStack(int capacity){
        element = new String[capacity];
        tos = -1;
    }

    @Override
    public int length(){
        return tos+1;
    }

    @Override
    public int capacity(){
        return element.length;
    }

    @Override
    public String pop(){
        if(tos == -1) return null;
        String s = element[tos];
        tos--;
        return s;
    }

    @Override
    public boolean push(String str){
        if(tos == element.length-1) {
            return false;
        } else{
            tos++;
            element[tos] =str;
            return true;
        }
    }
}



public class Chap5_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("총 스택 크기>>");

        int n=sc.nextInt();
        StringStack ss = new StringStack(n);

        while(true){
            System.out.println("문자열 입력 >>");
            String str = sc.next();
            if(str.equals("그만"))
                break;
            boolean res = ss.push(str);
            if (res == false) {

            System.out.println("스택이 꽉 차서 푸시 불가!");
        }}

        for(int i=0;i<ss.capacity();i++){
            System.out.print(ss.pop()+" ");
        }
        sc.close();
    }


}
