package javaProgramming;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Chap8_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileWriter fw = null;
        File f = new File("C:\\Users\\user\\Desktop\\phone.txt");
        try {
            fw = new FileWriter(f);

            while (true) {
                System.out.println("이름 전화번호 >>");
                String line = sc.nextLine();
                if (line.equals("그만"))
                    break;

                fw.write(line + "\r\n");
            }
            System.out.println(f.getPath()+"에 저장하였습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
