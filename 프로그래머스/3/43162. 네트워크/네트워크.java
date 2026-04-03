import java.util.*;
import java.io.*;

class Solution {
    static boolean[] visited;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        
       for(int i = 0; i < n ; i++) {
            if(!visited[i]) {
                answer++;
                dfs(i, computers, n);
            }
        }
        
        return answer;
    }
    
    static void dfs(int x, int[][] computers, int n) {
        visited[x] = true;
        
        for(int i = 0; i < n ; i++) {
            if(computers[x][i] == 1 && !visited[i] && x != i) {
                dfs(i, computers, n);
            }
        }
    }
}