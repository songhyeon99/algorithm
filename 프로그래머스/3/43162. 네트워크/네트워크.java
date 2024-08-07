import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(!visited[i]){
                bfs(i, n, computers);
                count++;
            }
        }
        return count;
    }
    static void bfs(int current, int n, int[][] computers){
        Queue<Integer> queue = new LinkedList<>();
        visited[current] = true;
        queue.add(current);
        
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int i = 0; i<n; i++){
                if(!visited[i] && num != i && computers[num][i] == 1){
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}