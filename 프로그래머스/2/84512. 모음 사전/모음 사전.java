import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static String[] alphabet = {"A", "E", "I", "O", "U"};
    
    static Set<String> set = new HashSet<>();
    
    static int wordLen = 5;
    
    static boolean found = false;
    
    public int solution(String word) {
        visited = new boolean[wordLen];
        
        
        for(int i = 0; i<wordLen; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(0, alphabet[i], word);
            }
        }
        
        return set.size();
    }
    
    void dfs(int depth, String current, String word) {
        
        if(found) return;
        
        if(depth == 5) return;
        
        if(current.length() <= wordLen) {
            System.out.printf("값 : %s\n", current);
            set.add(current);
            if(current.equals(word)) {
                found = true;
                return;
            }
        }
        
        for(int i = 0; i<wordLen; i++) {
            dfs(depth+1, current + alphabet[i], word);
        }
    }
}