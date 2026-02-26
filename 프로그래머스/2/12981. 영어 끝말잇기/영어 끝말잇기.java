import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        Set<String> usedWords = new HashSet<>();
        char lastAlphabet = words[0].charAt(words[0].length()-1);
        usedWords.add(words[0]);
        
        for(int i = 1 ; i <words.length ; i++) {
            char startAlphabet = words[i].charAt(0);
            if(lastAlphabet != startAlphabet || usedWords.contains(words[i])) {
                int idx = (i+1) % n;
                int person = idx == 0 ? n : idx;
                int order = (i / n ) + 1;
                answer[0] = person;
                answer[1] = order;
                return answer;
            }
            usedWords.add(words[i]);
            lastAlphabet = words[i].charAt(words[i].length()-1);
        }

        return answer;
    }
}