package baekjoon_algorithm.src;

import java.util.*;


public class GroupWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("숫자 입력하세요>> ");
            int count=0;
            int num = sc.nextInt();
            for (int i = 0; i < num; i++) {
                String word = sc.next();
                boolean[] Alphabet = new boolean[26];
                Arrays.fill(Alphabet, false);
                for (int j = 0; j < word.length(); j++) {
                    if (j>0&&word.charAt(j) == word.charAt(j - 1)) {
                        continue;
                    } else if (j>0&&word.charAt(j) != word.charAt(j - 1) && Alphabet[word.charAt(j) - 97]==true) {
                        count++;
                        break;
                    } else{
                        Alphabet[word.charAt(j) - 97] = true;
                    }
                }
            }

                System.out.println(num - count);
        }


}
