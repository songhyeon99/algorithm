import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static Queue<Integer> q = new LinkedList<>();
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];
        
        for(int i = 0; i<n; i++) {
            if(!visited[i]) {
                answer++;
                bfs(i, n, computers);
            }
        }
        return answer;
    }
    
    void bfs(int current, int n, int[][] computers) {
        q.add(current);
        visited[current] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int i = 0; i<n; i++) {
                if(computers[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}