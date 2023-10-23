package javaProgramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Chap8_2 {
    public static void main(String[] args) {
        BufferedReader fr = null;
        File file = new File("C:\\Users\\user\\Desktop\\phone.txt");
        try {
            fr = new BufferedReader(new FileReader(file));
            System.out.println(file.getPath() + "를 출력합니다.");
            while (true) {
                String line = fr.readLine();
                if (line == null) break;
                System.out.print(line+"\n");
            }
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
