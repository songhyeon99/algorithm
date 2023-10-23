package javaProgramming;

import java.util.Scanner;

public class Chap6_8 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("문자열을 입력하세요. 빈칸이 있어도 되고 영어 한글 모두 됩니다.");

        String text = sc.nextLine();
        int len = text.length();
        for(int i=0;i<len;i++){
            String first = text.substring(0,1);
            String last = text.substring(1);
            text =last +first;
            System.out.println(text);

        }
    }
}
