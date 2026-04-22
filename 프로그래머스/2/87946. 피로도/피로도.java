import java.io.*;
import java.util.*;

class Solution {
    static int answer = -1;
    static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        
        dfs(k, 0, dungeons);
        
        return answer;
    }
    
    int dfs(int currentK, int count, int[][] dungeons) {
        for(int i = 0; i<dungeons.length; i++) {
            if(!visited[i] && currentK >= dungeons[i][0]) {
                int nextK = currentK - dungeons[i][1];
                int nextCount = count + 1;
                visited[i] = true;
                int temp = dfs(nextK, nextCount, dungeons);
                answer = temp > answer ? temp : answer;
                visited[i] = false;
            }
        }
        return count;
    }
}