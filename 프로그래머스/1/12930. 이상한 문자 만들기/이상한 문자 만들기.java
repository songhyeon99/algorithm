import java.util.*;
import java.io.*;

class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] c = s.toCharArray();
        int idx = 0;
        for(int i = 0; i<c.length; i++) {
            if (c[i] == ' ') {
                answer.append(' ');
                idx = 0;
            } else {
                if (idx % 2 == 0) {
                    answer.append(Character.toUpperCase(c[i]));
                } else {
                    answer.append(Character.toLowerCase(c[i]));
                }
                idx++;
            }
            }
        return answer.toString();
    }
}