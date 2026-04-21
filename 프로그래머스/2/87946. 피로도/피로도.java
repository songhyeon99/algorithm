import java.io.*;
import java.util.*;

class Solution {
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        boolean[] visited = new boolean[dungeons.length];
        
        int count = dfs(k, dungeons, visited, 0, 0);
        
        return answer;
    }
    
    int dfs(int current, int[][] dungeons, boolean[] visited, int count, int depth) {
        if(depth == dungeons.length){
            return count;
        }
        
        for(int i = 0; i<dungeons.length; i++) {
            if(!visited[i]){
                if(current >= dungeons[i][0]) {
                    int nextCurrent = current - dungeons[i][1];
                    int nextCount = count+1;
                    visited[i] = true;
                    int result = dfs(nextCurrent, dungeons, visited, nextCount, depth+1);
                    answer = answer < result ? result : answer;
                    visited[i] = false;
                }
            }
        }
        return count;
    }
}