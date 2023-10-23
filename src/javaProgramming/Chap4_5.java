package javaProgramming;

import java.util.Scanner;

class Circles{
    double x, y;
    int radius;
    public Circles(double x, double y, int radius) { // x, y, radius 초기화
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void show() {
        System.out.println("("+x+","+y+")"+radius);
    }
}

public class Chap4_5 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Circles c[] = new Circles[3]; // 3개의 Circle 배열 선언
        for(int i=0; i<c.length; i++) {
            System.out.print("x, y, radius >>");
            double x = scanner.nextDouble(); // x 값 읽기
            double y = scanner.nextDouble(); // y 값 읽기
            int radius = scanner.nextInt(); // 반지름 읽기
            c[i] = new Circles(x, y, radius); // Circle 객체 생성
        }
        for(int i=0; i<c.length; i++)	c[i].show(); // 모든 Circle 객체 출력
        scanner.close();
    }
}