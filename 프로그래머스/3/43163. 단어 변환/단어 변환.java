import java.io.*;
import java.util.*;

class Solution {
    static Queue<Position> q = new LinkedList<>();
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        boolean result = bfs(begin, target, words);
        
        return result ? answer : 0;
    }
    
    boolean bfs(String word, String target, String[] words) {
        q.add(new Position(word, 0));
        
        while(!q.isEmpty()) {
            Position current = q.poll();
            if(target.equals(current.word)) {
                answer = current.count;
                return true;
            }
            
            for(int i = 0; i<words.length; i++) {
                if(!visited[i]){
                    int check = compareWord(current.word, words[i]);
                    if(check == 1) {
                        q.add(new Position(words[i], current.count + 1));
                        visited[i] = true;
                    }

                }
            }
        }
        return false;
    }
    
    int compareWord(String curWord, String nextWord) {
        int count = 0;
        for(int i = 0; i < curWord.length(); i++) {
            if(curWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        
        return count;
    }
    
    class Position {
        String word;
        int count;
        
        Position(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}