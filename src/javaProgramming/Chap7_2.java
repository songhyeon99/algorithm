package javaProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class Chap7_2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<Character> grade = new ArrayList<>();
        double sum = 0;
        System.out.println("6개의 학점을 빈 칸으로 분리 입력(A/B/C/D/F)>>");
        for(int i=0;i<6;i++) {
            char ch = sc.next().charAt(0);
            grade.add(ch);



            double score = 0;
            switch (ch) {
                case 'A':
                    score += 4.0;
                    break;
                case 'B':
                    score += 3.0;
                    break;
                case 'C':
                    score += 2.0;
                    break;
                case 'D':
                    score += 1.0;
                    break;
                case 'F':
                    score += 0.0;
                    break;

            }
            sum += score;

    }
        System.out.println(sum/6.0);
    }
}
